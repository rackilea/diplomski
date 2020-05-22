findViewById(R.id.addMarker).setOnClickListener(
            new View.OnClickListener(){
                @Override
                public  void onClick(View view) {
                    if(myMap != null){
                        double myLat = myMap.getCameraPosition().target.latitude;
                        double myLng = myMap.getCameraPosition().target.longitude;
                        LatLng markerPoint = new LatLng(myLat, myLng);
                        myMap.addMarker(new MarkerOptions().position(markerPoint)).setTitle("next marker");
                    }
                }
            }
    );