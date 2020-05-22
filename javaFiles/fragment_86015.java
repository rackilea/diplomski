if (client != null) {
    // Add client to map
    mMap.addMarker(new MarkerOptions().position(new LatLng(location.latitude, location.longitude))
                        .flat(true).title(client.getName())
                        .snippet("Phone: "+client.getPhone())
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.repair)));
            }
}