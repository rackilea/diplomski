if(isConnected)
 {
   if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
   {
       Toast toast = Toast.makeText(context, "Connected to wifi", Toast.LENGTH_LONG);
       toast.show();
   }
   else if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
   {
       Toast toast = Toast.makeText(context, "Connected to Mobile Data Pakage", Toast.LENGTH_LONG);
       toast.show();

   }
 }
 else 
  {
     Toast toast = Toast.makeText(context, "Not Connected", Toast.LENGTH_LONG);
     toast.show();

  }
 }