package com.example.ecolab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity {
    private Button play, chall, credits, exit;

    /*

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        chall = findViewById(R.id.chall);
        credits = findViewById(R.id.credits);
        exit = findViewById(R.id.exit);

        play.setOnClickListener(new OnClick());

        chall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(-1);
                finish();
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

    class OnClick implements OnMapReadyCallback, View.OnClickListener {



        @Override
        public void onClick(View v) {
            setContentView(R.layout.map);

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            // Add a marker in Eastern Slovakia and move the camera
            LatLng ostrov = new LatLng(48.70525, 21.24925);
            googleMap.addMarker(new MarkerOptions().position(ostrov).title("SOS Ostrovskeho").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


            LatLng spseke = new LatLng(48.73343, 21.24767);
            googleMap.addMarker(new MarkerOptions().position(spseke).title("SPS Elektrotechnicka").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


            LatLng kukuc = new LatLng(48.71389, 21.25022);
            googleMap.addMarker(new MarkerOptions().position(kukuc).title("SOST Kukucinova 23").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));;


            LatLng upjs = new LatLng(48.71931, 21.25122);
            googleMap.addMarker(new MarkerOptions().position(upjs).title("UPJS").icon(BitmapDescriptorFactory.defaultMarker(100)));


            LatLng tuke = new LatLng(48.73062, 21.24534);
            googleMap.addMarker(new MarkerOptions().position(tuke).title("TUKE").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


            LatLng itValley = new LatLng(48.73181, 21.24429);
            googleMap.addMarker(new MarkerOptions().position(itValley).title("IT Valley"));
;

            LatLng syntax = new LatLng(48.71873, 21.26459);
            googleMap.addMarker(new MarkerOptions().position(syntax).title("Syntax"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(syntax, 8));

            LatLng siemens = new LatLng(48.71747, 21.23491);
            googleMap.addMarker(new MarkerOptions().position(siemens).title("Siemens"));


            LatLng tsys = new LatLng(48.70748, 21.24749);
            googleMap.addMarker(new MarkerOptions().position(tsys).title("T-systems"));


            LatLng casof = new LatLng(48.71754, 21.22532);
            googleMap.addMarker(new MarkerOptions().position(casof).title("Cassovia Software"));


            LatLng connectPro = new LatLng(48.94678, 20.56616);
            googleMap.addMarker(new MarkerOptions().position(connectPro).title("ConnectPro s.r.o"));


            LatLng tostad = new LatLng(48.96904, 21.25271);
            googleMap.addMarker(new MarkerOptions().position(tostad).title("TOSTAD.sk"));


            LatLng m3soft = new LatLng(49.05835, 20.29028);
            googleMap.addMarker(new MarkerOptions().position(m3soft).title("M3Soft s.r.o"));


            LatLng dalnet = new LatLng(48.75635, 21.90596);
            googleMap.addMarker(new MarkerOptions().position(dalnet).title("DALNet s.r.o"));
        }
    }
}