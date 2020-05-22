for (int i = 0; i < list.size(); i++) {

            Marker marker;
            marker = gMap.addMarker(new MarkerOptions().position(new LatLng(list.getLat(), list.getLng()))
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location_other))
                        .flat(true));
           }