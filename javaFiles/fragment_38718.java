mMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
            Intent intent = new Intent(MainActivity.this, MarkerAdded.class);
            startActivity(intent);


            }
        });