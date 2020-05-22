public void onRequestPermissionsResult(int requestCode, String[] permissions,
            int[] grantResults) {

   if( requestCode == REQUEST_WRITE_EXTERNAL_STORAGE)
   {
       if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
             //Do something if the permission is granted
       }
       else
       {
             //Do something if the permission denied
       }
   }
}