MarkerClickCB mCallbacks; //communicates with the activity
   //interface set up
     public interface MarkerClickCB {
            void onMarkerSelected(String place, GoogePlaces place1);
        }

    ....

 mMap.setOnMarkerClickListener(new OnMarkerClickListener() {

        @Override
        public boolean onMarkerClick(Marker marker) {

            if (!mClusterManager.onMarkerClick(marker)) {
                googLocation = marker;
                cluster.getPosition();
                if (googLocation.equals(userLocMarker) && clusts2 == null) {
                    searchFilter();
                }
                if (marker.equals(userLocMarker) && nearby != null) {
                    for (Marker placeMarker : nearby.keySet()) {
                        placeMarker.setVisible(!placeMarker.isVisible());
                    }
                } else if (cluster != null) {

                    mCallbacks.onMarkerSelected("PLACE", clickedClusterItem.getPlace());
                    getDistance(clickedClusterItem.getPosition().latitude, clickedClusterItem.getPosition().longitude);

                    return true;
                }
            }
            return false;
        }
    });