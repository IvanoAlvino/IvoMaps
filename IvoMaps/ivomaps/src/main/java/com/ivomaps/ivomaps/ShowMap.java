package com.ivomaps.ivomaps;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.MapFragment;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class ShowMap extends ActionBarActivity {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_map);
        setUpMap();
        // obtainJSON();
        setMarkersInRadius(Int radius);
    }


    private void setUpMap() {
        if (mMap == null) {
            // the map is not set yet, let's set it now
            mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                    .getMap();
        }
    }

    private void setMarkersInRadius(Int radius) {
        if (mMap != null) {
            // --if map has been set, let's set up the marker looking by radius--
            // cerco in tutto il vettore ottenuto dal JSON i posti
            // con distanza minore di 'radius', e per ognuno addMarker()
            mMap.addMarker(new MarkerOptions().position(new LatLng(37.178531, -3.606279)).title("Casa"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.show_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
