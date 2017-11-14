package edu.upi.mobprogproject.content;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import edu.upi.mobprogproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{

//    static final LatLng GIK = new LatLng(-6.860426,107.589880);
    private Toolbar toolbar4;
    MapView mapView;
    private GoogleMap map;
//    private SupportMapFragment map;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

//        map = ((SupportMapFragment)getFragmentManager().findFragmentById(R.id.mapView)).getMap();

        toolbar4 = rootView.findViewById(R.id.toolbar3);

        if (toolbar4 != null) {
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar4);
        }
        //toolbar4.setTitle(null);

        mapView = (MapView) rootView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        mapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                map = mMap;

                // For showing a move to my location button
                //map.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                LatLng sydney = new LatLng(-6.860426, 107.589880);
                map.addMarker(new MarkerOptions().position(sydney).title("I'm Here!").snippet("Saya disini heem iyah."));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

//        googleMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.mapView)).getMap();
//        map.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


}
