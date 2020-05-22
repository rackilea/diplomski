mMap.addMarker(new MarkerOptions()
                    .position(markerLatLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker))
                    .anchor(0.5f, 0.5f)
                    .rotation(bearing)
                    .flat(true));