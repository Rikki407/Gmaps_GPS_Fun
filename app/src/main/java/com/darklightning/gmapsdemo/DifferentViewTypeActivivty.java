package com.darklightning.gmapsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class DifferentViewTypeActivivty extends AppCompatActivity implements OnMapReadyCallback,View.OnClickListener{
    boolean map_ready;
    GoogleMap m_map;
    Button btnMap,btnSatallite,btnHybrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.different_view_type_activity);
        btnMap = (Button) findViewById(R.id.btn_map);
        btnSatallite = (Button) findViewById(R.id.btn_satellite);
        btnHybrid = (Button) findViewById(R.id.btn_hybrid);
        btnMap.setOnClickListener(this);
        btnHybrid.setOnClickListener(this);
        btnSatallite.setOnClickListener(this);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map_ready = true;
        m_map = googleMap;
        LatLng newYork = new LatLng(40.7484,-73.9857);
        CameraPosition target = CameraPosition.builder().target(newYork).zoom(24).tilt(60).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_map :
                if(map_ready==true) {
                    m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
                break;
            case R.id.btn_satellite :
                if(map_ready==true) {
                    m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }
                break;
            case R.id.btn_hybrid :
                if(map_ready==true) {
                    m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
                break;
        }
    }
}
