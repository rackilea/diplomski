package com.example.wince.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by Wince on 31.05.2016.
 */
public class RotaGoster extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rota);
        String isim = getIntent().getExtras().getString("DB_name");
        VeriTabani VT = new VeriTabani(this);
        Button Kayit = (Button) findViewById(R.id.button6);
        Button Rota = (Button) findViewById(R.id.button7);
        int i = 0;
        final Intent rotaIntent = new Intent(this, Rota.class);
        final Intent kayitIntent = new Intent(this, RotaKayit.class);
        ArrayList<Yer> yerler = new ArrayList<>();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);
        yerler.addAll(VT.getAllYer());
        for (i = 0; i < yerler.size(); i++) {
            if (yerler.get(i).equals(isim)) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(VT.getYer(i).getLat(), VT.getYer(i).getLng())).title(i + "'inci nokta"));
            }

        }

        Kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(kayitIntent);
                finish();
            }
        });

        Rota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(rotaIntent);
                finish();
            }
        });


        //dbden verileri çekmek gerek


        // db işlemleri ve gösterim burda yapılıcak.


    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);

    }
}