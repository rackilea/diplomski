Geocoder geocoder = new Geocoder(this, Locale.US);

            double lat = 41.146064;
            double lon = 80.642861;

            try{
             List<Address> loc = geocoder.getFromLocationName(lat, lon, 5);
            }
            catch(IOException e) {
             Log.e("IOException", e.getMessage()); 
             Toast.makeText(this, "IOException:  " + e.getMessage(),20).show();
                }
                 //DO something with loc