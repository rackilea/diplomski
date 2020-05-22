@Override
        protected void onPause() {
        super.onPause();
        if (myLocations.size() > 0 ) {
                mapsIntent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putStringArrayListExtra("locations", myLocations);
                intent.putStringArrayListExtra("loc1", vLoc1);
                intent.putStringArrayListExtra("loc2", vLoc2);
                startActivity(intent);
                finish();
            }
        }