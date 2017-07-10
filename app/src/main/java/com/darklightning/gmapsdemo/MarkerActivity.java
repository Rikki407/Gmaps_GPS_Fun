package com.darklightning.gmapsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarkerActivity extends AppCompatActivity implements OnMapReadyCallback
{

    GoogleMap g_map;
    boolean map_ready=false;

    MarkerOptions renton,kirkland,everett,lynrwood,nontlake,kint;

    static final CameraPosition SEATLE = CameraPosition.builder().target(new LatLng(47.6204,-122.2491)).zoom(10).bearing(0).tilt(45).build();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker);

        renton = new MarkerOptions().position(new LatLng(47.489805,-122.120502)).title("renton");
        kirkland  = new MarkerOptions().position(new LatLng(47.7301986,-122.1768858)).title("kirkland");
        everett = new MarkerOptions().position(new LatLng(47.978748,-122.202001)).title("everett");
        lynrwood = new MarkerOptions().position(new LatLng(47.819533,-122.3288)).title("lynrwood");
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.marker_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map_ready=true;
        g_map = googleMap;
        g_map.moveCamera(CameraUpdateFactory.newCameraPosition(SEATLE));
        g_map.addMarker(renton);
        g_map.addMarker(kirkland);
        g_map.addMarker(everett);
        g_map.addMarker(lynrwood);
        g_map.moveCamera(CameraUpdateFactory.newCameraPosition(SEATLE));

    }
}
