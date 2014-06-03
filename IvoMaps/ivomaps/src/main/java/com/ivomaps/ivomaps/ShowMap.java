package com.ivomaps.ivomaps;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.MapFragment;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class ShowMap extends ActionBarActivity {

    private GoogleMap mMap;
    private double radius = 3.0;
    private TextView radiusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_map);
        /* set maps */
        setUpMap();

        /*** Initializations ***/
        if ( savedInstanceState != null ) {
            // Set the previous value of radius
            radius = savedInstanceState.getDouble("Radius");
            // Set the previous camera position
            CameraPosition cp = savedInstanceState.getParcelable("CameraPosition");
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
        }
        else {
            // set the view to Granada
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.179373, -3.600186), 13));
        }

        /* Set the view of the radius indicator (top left) */
        radiusView = (TextView) findViewById(R.id.radiusView);
        radiusView.setText(String.valueOf(radius));
        // obtainJSON();
        setMarkersInRadius(radius);
    }

    private void setUpMap() {
        if (mMap == null) {
            // the map is not set yet, let's set it now
            mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            // add the My Location Button
            mMap.setMyLocationEnabled(true);
        }
    }

    public void onClickIncrease(View view) {
        if ( radius < 150 ) {
            radius += 0.5;
            radiusView.setText(String.valueOf(radius));
        }
        return;
    }

    public void onClickDecrease(View view) {
        if ( radius > 0.5 ) {
            radius -= 0.5;
            radiusView.setText(String.valueOf(radius));
        }
        return;
    }

    private void setMarkersInRadius(double radius) {
        if (mMap != null) {
            // --if map has been set, let's set up the marker looking by radius--

            /* BETTER VERSION
                Add all the marker to the map, store them in a Hash table.
                For every marker, see the distance from user and use
                marker.isVisibile() TRUE or FALSE
             */

            Marker home = mMap.addMarker(new MarkerOptions().position(new LatLng(37.178531, -3.606279)).title("Home"));
        }
    }

    protected void onSaveInstanceState( Bundle outBundle) {
        // saving radius
        outBundle.putDouble("Radius", radius);
        // saving camera position
        outBundle.putParcelable("CameraPosition", mMap.getCameraPosition());
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
