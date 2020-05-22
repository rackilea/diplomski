listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            // Get the {@link Attractions} object at the given position the user clicked on
            Attractions attractions = attraction.get(position);

            String lat = getString(attractions.getLatitude());
            latitude = Double.parseDouble(lat);
            String lon = getString(attractions.getLongitude());
            longitude = Double.parseDouble(lon);

            //Open map app to the address
            String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        }
    });