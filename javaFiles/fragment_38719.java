mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.equals(yourMarkerObj))// you should compare with your marker not with the google map obj  or you can normally pass the intent without condition
{
                    Intent intent = new Intent(MainActivity.this, MarkerAdded.class);
                    startActivity(intent);
                }
                    return false;
            }
    });