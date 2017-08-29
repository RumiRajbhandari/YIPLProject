package com.example.root.yiplproject.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.root.yiplproject.FirstProject;
import com.example.root.yiplproject.R;
import com.example.root.yiplproject.SecondProject;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback,GoogleMap.OnPolylineClickListener,
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
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mgoogleMap=googleMap;
        Marker mbalkumari = googleMap.addMarker(new MarkerOptions()
                .position(balkumari)
                .title("Construction of drain, asphalt concrete")
                .snippet("Contract:Sunkoshi Construction "));
        Marker msatdobato = googleMap.addMarker(new MarkerOptions()
                .position(satdobato)
                .title("Construction of overhead pedestrian crossing Bridge")
                .snippet("Contract:Hirachan Construction"));
        Marker mKalanki = googleMap.addMarker(new MarkerOptions()
                .position(kalanki)
                .title("Contract:Santi Nirman Sewa")
                .snippet("Current Location:Kalanki" ));
        Marker mEkantakuna=googleMap.addMarker(new MarkerOptions()
                .position(ekantakuna)
                .title("Contract:Shuva Om Nirman Sewa")
                .snippet("Current Location:Ekantakuna" ));

        mgoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(balkumari, 12.0f));
        mgoogleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                String[] str = marker.getId().split("m");
                int i=Integer.parseInt(str[1]);
                if (i == 0) {
                    Intent in = new Intent(getContext(), FirstProject.class);
                    // aboutcsit.putExtra("listname",listView.getItemAtPosition(i).toString());
                    startActivity(in);
                }
                else if (i == 1) {
                    Intent inten = new Intent(getContext(), SecondProject.class);
                    //pakistan.putExtra("listname",listView.getItemAtPosition(i).toString());
                    startActivity(inten);
                }
            }
        });



    }
}
