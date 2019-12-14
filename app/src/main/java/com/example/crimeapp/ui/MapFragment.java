package com.example.crimeapp.ui;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import com.example.crimeapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.List;

import static android.content.Context.LOCATION_SERVICE;
import static java.util.Objects.requireNonNull;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    public GoogleMap mMap;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private SearchView searchView;

    public MapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_map, container, false);
        searchView=view.findViewById(R.id.sv);
        return view;

    }
       @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
           super.onViewCreated(view, savedInstanceState);
           SupportMapFragment supportMapFragment = (SupportMapFragment)
                   getChildFragmentManager().findFragmentById(R.id.map_fragment);


           searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
               @Override
               public boolean onQueryTextSubmit(String s) {
                   String location = searchView.getQuery().toString();
                   List<Address> addressList = null;

                   if (location != null || !location.equals("")) {
                       Geocoder geocoder = new Geocoder(getContext());
                       try {
                           addressList = geocoder.getFromLocationName(location, 3);
                       } catch (IOException e) {
                           e.printStackTrace();
                       }

                       Address address = addressList.get(2);
                       LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                       mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                       mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                   }else if(location==null){

                   }
                   return false;
               }

               @Override
               public boolean onQueryTextChange(String s) {
                   return true;
               }
           });

           if (supportMapFragment != null) {
               supportMapFragment.getMapAsync(this);

               ActivityCompat.requestPermissions(requireNonNull(getActivity()), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
               ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);

           }
       }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;

        locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                try{
                    LatLng latLng=new LatLng(location.getLatitude(),location.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                    mMap.getUiSettings().setMapToolbarEnabled(true);
                    mMap.getUiSettings().setMyLocationButtonEnabled(true);
                    mMap.setMyLocationEnabled(true);
                }catch (SecurityException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        locationManager=(LocationManager) getLayoutInflater().getContext().getSystemService(LOCATION_SERVICE);

        try {
            if (locationManager != null) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 1000, locationListener);
            }

        }catch (SecurityException e){
            e.printStackTrace();
        }
    }


}
