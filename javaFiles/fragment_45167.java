int marker_count=0;   
     mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {

                @Override
                public void onMapLongClick(LatLng arg0) {
                    if(marker_count<3){
    //if there is a marker already this if condition removes it

                   if (marker != null) {
                        marker.remove();
marker_count=marker_count-1;
                    }
marker_count=marker_count+1;
                    marker = mMap.addMarker(new MarkerOptions()
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_02))
                            .position(
                                    new LatLng(arg0.latitude,
                                            arg0.longitude))
                            .draggable(true).visible(true));
                }}
    else{
    //toast a message
    }
            });