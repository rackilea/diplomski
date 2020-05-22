for(int i = 0; i < locations.length; i++) {

        List<Address> list;
        Geocoder geo = new Geocoder(this); 
        try {
                String[] latlong = locations[i][1].split(",");
                list = geo.getFromLocation(Double.valueOf(latlong[0]), Double.valueOf(latlong[1]), 1); // the 1st result should be the best one
                Address ad = list.get(0); // Position 0 is the most specific to the coordinates.
                String buff = new String(); 
                for(int i = 0; i <= ad.getMaxAddressLineIndex(); i++ ) {
                     buff += ad.getAddressLine(i); // for a good addres(with street name u should get getMaxAddressLineIndex() = 2
                     // HERE you would want to do something with buff to show or to store it

                 }


                for (Address a : list) {
                    Log.v("TAG", a.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }