@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.fab.setOnClickListener(this);
        this.mapView = (MapView) this.rootView.findViewById(R.id.map);
        if (mapView != null) {
           his.mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    mMap = googleMap;
                    if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

  ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
                        return;
                    }
                    mMap.setMyLocationEnabled(true); //I DONT KNOW WHY IT DOES NOT WORK


                      }
                  });

        }