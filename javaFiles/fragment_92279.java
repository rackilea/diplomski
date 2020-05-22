Location location;

 @Override
  protected void onCreate(Bundle savedInstanceState) 
  {
     super.onCreate(savedInstanceState);
     gpsLocation(this);
     while(location == null)
         continue;
     Log.w("GPS LOCATION", "LOCATION FOUND");
}


 public static void gpsLocation(FragmentActivity context)
 {

    LocationManager provider = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    UserLocator     locator  = new UserLocator();
    provider.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locator);
 }


  class UserLocator implements LocationListener
   {
       public void onLocationChanged(Location loc)
       {
            if(loc != null)
                 location = loc;

  }
   public void onProviderDisabled(String provider) {}
   public void onProviderEnabled(String provider)  {}
   public void onStatusChanged(String provider, int status, Bundle extras) {} 
}