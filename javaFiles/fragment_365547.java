runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longtitude)).title("Statue").snippet("Something"));
                    }
                });