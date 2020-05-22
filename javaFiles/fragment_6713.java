public class Activity extends FragmentActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.setContentView(R.layout.activity_layout);

                .......

            //Set up map view
            map = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

            mHandler = new LocationHandler(this); 
                .......

        OnMarkerDragListener markerDragListener = new OnMarkerDragListener() {

                @Override
                public void onMarkerDragStart(Marker marker) {
                    // Called when the marker drag is started

                }

                @Override
                public void onMarkerDragEnd(Marker marker) {
                    // Called when the marker is dropped down.
                    coords[0] = marker.getPosition().latitude;
                    coords[1] = marker.getPosition().longitude;
                    RestoreUIwithSavedLocation(coords);
                    Log.d(TAG, "Pin Dropped at: " + coords[0] + ", " + coords[1]);
                }

                @Override
                public void onMarkerDrag(Marker marker) {

                }
            };

            map.setOnMarkerDragListener(markerDragListener);
        }
    }

    private void RestoreUIwithSavedLocation(double[] coordsArray) {
        Message.obtain(mHandler, LOAD_COORD, coordsArray).sendToTarget();
    }

    // Write a inner class
    static class LocationHandler extends Handler {
        WeakReference<Activity> mActivity;

        public LocationHandler(Activity activity) {
            mActivity = new WeakReference<Activity>(activity);
        }

        public void handleMessage(Message msg) {
            Activity contextActivity = mActivity.get();
            switch ((int)msg.what) {

            case LOAD_COORD:
                map.clear();
                double[] coordArray = (double[])msg.obj;
                Marker marker = map.addMarker(new MarkerOptions().position(new LatLng(coordArray[0], coordArray[1])));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(coordArray[0], coordArray[1]), 18));
                map.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                marker.setDraggable(true);
                String s = Double.toString(coordArray[0]) + ", " + Double.toString(coordArray[1]);              
                contextActivity.text_location.setText(s);
                break;

            }
        }
    }
}