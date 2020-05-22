if (addressList == null)
    {
             Log.d(TAG,"Latitude and longitude not found");
    }
     else {
     Address location = addressList.get(0);
    latitude = location.getLatitude();
     longitude = location.getLongitude();
     }