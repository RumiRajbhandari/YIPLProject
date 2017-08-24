package com.example.root.yiplproject.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.root.yiplproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback,GoogleMap.OnPolylineClickListener, GoogleMap.OnInfoWindowClickListener,
        GoogleMap.OnPolygonClickListener {
    GoogleMap mgoogleMap;
    MapView mMapView;
    View mView;
    private static final LatLng balkumari=new LatLng(27.672695, 85.341360);
    private static final LatLng satdobato=new LatLng(27.656541, 85.322048);
    private static final LatLng ekantakuna=new LatLng(27.669056, 85.306103);
    private static final LatLng kalanki=new LatLng(27.694121, 85.281551);

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_map, container, false);
        return mView;


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView=(MapView)mView.findViewById(R.id.map);
        if (mMapView !=null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);

        }
    }

    @Override
    public void onPolygonClick(Polygon polygon) {



    }

    @Override
    public void onPolylineClick(Polyline polyline) {


    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
//        mgoogleMap=googleMap;
        PolylineOptions polylineOptions=new PolylineOptions().add(balkumari).add(satdobato).add(ekantakuna).add(kalanki).width(5).color(Color.BLUE).geodesic(true);
        Polyline polyline = googleMap.addPolyline(polylineOptions);
        polyline.setClickable(true);
        googleMap.addPolyline(polylineOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(balkumari,13));
        // Set listeners for click events.
googleMap.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() {
    @Override
    public void onPolylineClick(Polyline polyline) {

        Marker Bal = googleMap.addMarker(new MarkerOptions()
                .position(balkumari)
                .title("Contract:Hirachan Construction")
                .snippet("Current Location:Balkumari"));
        Bal.showInfoWindow();
        Marker Sat = googleMap.addMarker(new MarkerOptions()
                .position(satdobato)
                .title("Contract:Hirachan Construction")
                .snippet("Current Location:Satobato"));
        Sat.showInfoWindow();
        Marker Kalanki = googleMap.addMarker(new MarkerOptions()
                .position(kalanki)
                .title("Contract:Hirachan Construction")
                .snippet("Current Location:Kalanki" ));
        Kalanki.showInfoWindow();
        Marker Ekantakuna=googleMap.addMarker(new MarkerOptions()
        .position(ekantakuna)
                .title("Contract:Hirachan Construction")
                .snippet("Current Location:Ekantakuna" ));
        Ekantakuna.showInfoWindow();

    }
});

    }


    @Override
    public void onInfoWindowClick(Marker marker) {

    }
}
