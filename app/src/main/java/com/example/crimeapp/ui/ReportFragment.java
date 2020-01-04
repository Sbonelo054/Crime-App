package com.example.crimeapp.ui;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.crimeapp.Model.UserDetails;
import com.example.crimeapp.Networking.MySingleton;
import com.example.crimeapp.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class ReportFragment extends Fragment {
    private ImageView hijacking;
    private ImageView mugging;
    private ImageView stabbing;
    private ImageView shooting;
    private ImageView kidnapping;
    private ImageView sexualAssault;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private static String URL;
    // private static String URL="https://cloud.mongodb.com/v2/5deffe15ff7a25b466511707?csrfTime=1576179042422&csrfToken=be5abb6604261a5c12ae3ad7e740c6fe3ffba797&currentOrgId=5deffc99f2a30baa568a4a8c&email=nhlanhlanqondo%40gmail.com&needsMfa=false&uId=5deffc99f2a30baa568a4a8b#metrics/replicaSet/5defff317b6691839318b893/explorer/CrimeAppDatabase/CrimeAppCollection/find";
    private static final int MY_PERMISSION=1;
    private double lat;
    private double lon;


    public ReportFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMyPermission();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_report, container, false);
        hijacking = view.findViewById(R.id.hijacking);
        hijacking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view19) {
               // reportHijacking();
                MapFragment mapFragment = new MapFragment();
                FragmentManager manager = ReportFragment.this.getFragmentManager();
                if (manager != null) {
                    manager.beginTransaction().replace(R.id.map_fragment, mapFragment)
                            .commit();
                }

            }

        });

        mugging=view.findViewById(R.id.mugging);
        mugging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view12) {
          //      reportMugging();
                MapFragment mapFragment = new MapFragment();
                FragmentManager manager = ReportFragment.this.getFragmentManager();
                if (manager != null) {
                    manager.beginTransaction().replace(R.id.map_fragment, mapFragment)
                            .commit();
                }
            }
        });

        stabbing=view.findViewById(R.id.stabbing);
        stabbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view16) {
           //     reportStabbing();
                MapFragment mapFragment = new MapFragment();
                FragmentManager manager = ReportFragment.this.getFragmentManager();
                if (manager != null) {
                    manager.beginTransaction().replace(R.id.map_fragment, mapFragment)
                            .commit();
                }
            }
        });

        shooting=view.findViewById(R.id.shooting);
        shooting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view15) {
          //      reportShooting();
                MapFragment mapFragment = new MapFragment();
                FragmentManager manager = ReportFragment.this.getFragmentManager();
                if (manager != null) {
                    manager.beginTransaction().replace(R.id.map_fragment, mapFragment)
                            .commit();
                }
            }
        });
        kidnapping=view.findViewById(R.id.kidnapping);
        kidnapping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view14) {
              //  reportKidnapping();
                MapFragment mapFragment = new MapFragment();
                FragmentManager manager = ReportFragment.this.getFragmentManager();
                if (manager != null) {
                    manager.beginTransaction().replace(R.id.map_fragment, mapFragment)
                            .commit();
                }
            }
        });
        sexualAssault=view.findViewById(R.id.sexual_assault);
        sexualAssault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view13) {
             //   reportSexualAssault();
                MapFragment mapFragment = new MapFragment();
                FragmentManager manager = ReportFragment.this.getFragmentManager();
                if (manager != null) {
                    manager.beginTransaction().replace(R.id.map_fragment, mapFragment)
                            .commit();
                }
            }
        });
        return view;
    }

    public void setMyPermission(){
        ActivityCompat.requestPermissions(requireNonNull(getActivity()),
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
    }

    public void reportHijacking(){
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    lat=location.getLatitude();
                    lon=location.getLongitude();
                }
            }
        });
        StringRequest stringRequestHijacking=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //try {

              //  }catch (JSONException j){
                  //  j.getMessage();
            //    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.getMessage();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hijackingParams=new HashMap<>();
                hijackingParams.put("description", "Hijacking reported");
                hijackingParams.put("latitude", String.valueOf(lat));
                hijackingParams.put("longitude", String.valueOf(lon));
                return hijackingParams;
                /*So now only URL and Permission is left then the app is done*/
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQueue(stringRequestHijacking);
    }

    public void reportMugging(){
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    lat=location.getLatitude();
                    lon=location.getLongitude();
                }
            }
        });
        StringRequest stringRequestMugging=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> muggingParams=new HashMap<>();
                muggingParams.put("description","Mugging reported");
                muggingParams.put("latitude", String.valueOf(lat));
                muggingParams.put("longitude", String.valueOf(lon));
                return muggingParams;
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQueue(stringRequestMugging);
    }

    public void reportStabbing(){
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    lat=location.getLatitude();
                    lon=location.getLongitude();
                }
            }
        });
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    lat=location.getLatitude();
                    lon=location.getLongitude();
                }
            }
        });
        StringRequest stringRequestStabbing=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> stabbingParams=new HashMap<>();
                stabbingParams.put("description", "Stabbing reported");
                stabbingParams.put("latitude", String.valueOf(lat));
                stabbingParams.put("longitude", String.valueOf(lon));
                return stabbingParams;
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQueue(stringRequestStabbing);
    }

    public void reportShooting(){
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    lat=location.getLatitude();
                    lon=location.getLongitude();
                }
            }
        });
        StringRequest stringRequestShooting=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> shootingParams=new HashMap<>();
                shootingParams.put("description", "Shooting reported");
                shootingParams.put("latitude", String.valueOf(lat));
                shootingParams.put("longitude", String.valueOf(lon));
                return shootingParams;
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQueue(stringRequestShooting);
    }

    public void reportKidnapping(){
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    lat=location.getLatitude();
                    lon=location.getLongitude();
                }
            }
        });
        StringRequest stringRequestKidnapping =new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> kidnappingParams=new HashMap<>();
                kidnappingParams.put("description", "Kidnapping reported");
                kidnappingParams.put("latitude", String.valueOf(lat));
                kidnappingParams.put("longitude", String.valueOf(lon));
                return kidnappingParams;
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQueue(stringRequestKidnapping);
    }

    public void reportSexualAssault(){
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    lat=location.getLatitude();
                    lon=location.getLongitude();
                }
            }
        });
        StringRequest stringRequestSexualAssault=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> sexualAssaultParams=new HashMap<>();
                sexualAssaultParams.put("description", "Sexual assault reported");
                sexualAssaultParams.put("latitude", String.valueOf(lat));
                sexualAssaultParams.put("longitude", String.valueOf(lon));
                return sexualAssaultParams;
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQueue(stringRequestSexualAssault);
    }
}
