if (requestCode == 5 && resultCode == RESULT_OK) {
        Toast.makeText(this,"here",Toast.LENGTH_SHORT).show();
        if (data != null) {
            Place place = PlacePicker.getPlace(data, this);
            if (place != null) {
                lat = place.getLatLng().latitude;
                lng = place.getLatLng().longitude;
                MarkerOptions marker = new MarkerOptions().position(
                        place.getLatLng()).title("Hello Maps"); marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED));
                      googleMap.addMarker(marker);
            } else{
                Toast.makeText(this,"place",Toast.LENGTH_SHORT).show();
                MarkerOptions marker = new MarkerOptions().position(
                        new LatLng(latitude, longitude)).title("Hello Maps");
                lat = latitude;
                lng = longitude;
                // Changing marker icon
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

                // adding marker
                googleMap.addMarker(marker);
            }
        } else{
            Toast.makeText(this,"data",Toast.LENGTH_SHORT).show();
            MarkerOptions marker = new MarkerOptions().position(
                    new LatLng(latitude, longitude)).title("Hello Maps");
            lat = latitude;
            lng = longitude;
            // Changing marker icon
            marker.icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

            // adding marker
            googleMap.addMarker(marker);
        }
}else if(requestCode == 5 && resultCode == RESULT_CANCELED){
    // handle no selection here
}