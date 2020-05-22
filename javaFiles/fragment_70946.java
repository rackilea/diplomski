MapView mMapView;
        private GoogleMap googleMap;
        Location location;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // inflat and return the layout
            View v = inflater.inflate(R.layout.fragment_main, container,
                    false);
            mMapView = (MapView) v.findViewById(R.id.mapView);
            mMapView.onCreate(savedInstanceState);

            mMapView.onResume();// needed to get the map to display immediately

            try {
                MapsInitializer.initialize(getActivity().getApplicationContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
            googleMap = mMapView.getMap();
            googleMap.setMyLocationEnabled(true);

            location = googleMap.getMyLocation();

            if (location != null) {

                // latitude and longitude
                LatLng lat = new LatLng(location.getLatitude(), location.getLongitude());

                //double latitude = 17.385044;
                //double longitude = 78.486671;
                //LatLng lat = new LatLng(latitude,longitude);

                // create marker

                MarkerOptions marker = new MarkerOptions().position(
                        lat).title("Hello Maps");

                // Changing marker icon
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

                // adding marker
                googleMap.addMarker(marker);

                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(lat).zoom(12).build();


                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));

            }

            // Perform any camera updates here
            return v;
        }