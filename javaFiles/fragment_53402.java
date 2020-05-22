if(addresses.size() > 0){
    String street = addresses.get(0).getThoroughfare();
          Log.i("I0",street);


          String city = addresses.get(0).getLocality();
          Log.i("I1",city);

          String county = addresses.get(0).getSubAdminArea();
          Log.i("I2",county);

          String country = addresses.get(0).getCountryName();
          Log.i("I3",country);
          String postalCode = addresses.get(0).getPostalCode();
          Log.i("I4",postalCode);

          display.setText(street + "\n" + city + "\n" + country + "\n" + postalCode  ); 
}