map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {

            LatLng latLon = marker.getPosition();

            //Cycle through places array
            for(Place place : places){
               if (latLon.equals(place.latlng)){
                    //match found!  Do something....
               }

            }
        }
    });