mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
    {

        @Override
        public boolean onMarkerClick(Marker arg0) {
            String title;
            title = arg0.getTitle();
            Toast.makeText(getApplicationContext(), title, Toast.LENGTH_LONG).show();
            return true;
        }

    });