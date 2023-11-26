package com.example.ecolab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button play, chall, credits, exit, confirm, btBack;
    private int coins, count;
    private File file;
    private TextView qeustion;

    private TextInputEditText answer;

    private ArrayList<String> questions, answers;

    private TextView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        count = 0;
        main();

    }

    public void main() {
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        chall = findViewById(R.id.chall);
        credits = findViewById(R.id.credits);
        exit = findViewById(R.id.exit);


        play.setOnClickListener(new OnClick());

        chall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                challenge();

            }
        });
        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(-1);
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(-1);
                finish();
            }
        });
    }

    public void challenge() {
        setContentView(R.layout.challenge);

        questions = new ArrayList<>();
        questions.add("At which university in Kosice is Java taught is the first year?");
        questions.add("Which company has this slogan: Together, we accelerate reinvention?");
        questions.add("At which school does PI Day take place regularly?");

        answers = new ArrayList<>();
        answers.add("UPJS");
        answers.add("Accenture");
        answers.add("SPSEKE");

        qeustion = findViewById(R.id.quest);
        qeustion.setText(questions.get(count));

        confirm = findViewById(R.id.conf);
        // answer = findViewById(R.id.ans);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = findViewById(R.id.coins);
                answer = findViewById(R.id.ans);
                //String text = String.valueOf(answer.getText());
                if((answer.getText().toString()).equals(answers.get(count))){
                    coins = coins + 2;
                    c.setText(String.valueOf(coins));
                }
                count++;
                if(count >= 3) main();
                else qeustion.setText(questions.get(count));
            }
        });

        btBack = findViewById(R.id.but_back);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main();
            }
        });
    }
    class OnClick implements OnMapReadyCallback, View.OnClickListener, GoogleMap.OnMarkerClickListener {
        private Marker m_ostrov, m_spseke, m_kukuc, m_upjs, m_tuke;
        private ConstraintLayout constraintLayout;
        private Button bt_back;


        @Override
        public void onClick(View v) {
            setContentView(R.layout.map);
            bt_back = findViewById(R.id.but_back);
            bt_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    main();
                }
            });
            constraintLayout = findViewById(R.id.open);
            constraintLayout.setVisibility(View.INVISIBLE);


            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            // Add a marker in Eastern Slovakia and move the camera
            LatLng ostrov = new LatLng(48.70525, 21.24925);
            googleMap.setOnMarkerClickListener(this);
            m_ostrov = googleMap.addMarker(new MarkerOptions().position(ostrov).title("SOS Ostrovskeho").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
           // googleMap.setOnMarkerClickListener(m_ostrov);

            LatLng spseke = new LatLng(48.73343, 21.24767);
            googleMap.addMarker(new MarkerOptions().position(spseke).title("SPS Elektrotechnicka").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


            LatLng kukuc = new LatLng(48.71389, 21.25022);
            googleMap.addMarker(new MarkerOptions().position(kukuc).title("SOST Kukucinova 23").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));;


            LatLng upjs = new LatLng(48.71931, 21.25122);
            googleMap.addMarker(new MarkerOptions().position(upjs).title("UPJS").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));


            LatLng tuke = new LatLng(48.73062, 21.24534);
            googleMap.addMarker(new MarkerOptions().position(tuke).title("TUKE").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));


            LatLng itValley = new LatLng(48.73181, 21.24429);
            googleMap.addMarker(new MarkerOptions().position(itValley).title("IT Valley").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));
;

            LatLng syntax = new LatLng(48.71873, 21.26459);
            googleMap.addMarker(new MarkerOptions().position(syntax).title("Syntax").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(syntax, 8));


            LatLng siemens = new LatLng(48.71747, 21.23491);
            googleMap.addMarker(new MarkerOptions().position(siemens).title("Siemens").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));


            LatLng tsys = new LatLng(48.70748, 21.24749);
            googleMap.addMarker(new MarkerOptions().position(tsys).title("T-systems").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));


            LatLng casof = new LatLng(48.71754, 21.22532);
            googleMap.addMarker(new MarkerOptions().position(casof).title("Cassovia Software").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));


            LatLng connectPro = new LatLng(48.94678, 20.56616);
            googleMap.addMarker(new MarkerOptions().position(connectPro).title("ConnectPro s.r.o").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));


            LatLng tostad = new LatLng(48.96904, 21.25271);
            googleMap.addMarker(new MarkerOptions().position(tostad).title("TOSTAD.sk").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));


            LatLng m3soft = new LatLng(49.05835, 20.29028);
            googleMap.addMarker(new MarkerOptions().position(m3soft).title("M3Soft s.r.o").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));


            LatLng dalnet = new LatLng(48.75635, 21.90596);
            googleMap.addMarker(new MarkerOptions().position(dalnet).title("DALNet s.r.o").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));
        }

        @Override
        public boolean onMarkerClick(@NonNull Marker marker) {
            if (marker.equals(m_ostrov)) {
               constraintLayout.setVisibility(View.VISIBLE);
            }
            return false;
        }
    }
}