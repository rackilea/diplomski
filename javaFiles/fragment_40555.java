findViewById(R.id.device_button).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

      Location lastKnownLocation = mapboxMap.getLocationComponent().getLastKnownLocation();

      if (lastKnownLocation != null) {

        CameraPosition position = new CameraPosition.Builder()
          .target(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude())) // Sets the new camera position
          .zoom(16)
          .bearing(0)
          .tilt(0)
          .build(); // Creates a CameraPosition from the builder

        mapboxMap.animateCamera(CameraUpdateFactory
          .newCameraPosition(position), 7000);
      }

    }
  });