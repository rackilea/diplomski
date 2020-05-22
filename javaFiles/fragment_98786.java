getMarkers(new VolleyCallBack() {

                @Override
                public void onSuccess() {
                    // this is where you will call the geofire, here you have the response from the volley.
                    geoQuery = geofire.queryAtLocation(new GeoLocation(latLng.latitude, latLng.longitude),0.1f);
                });