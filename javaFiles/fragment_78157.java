private boolean checkPermission(){    
   if (android.os.Build.VERSION.SDK_INT >= 23 &&
   ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)== 
   PackageManager.PERMISSION_DENIED) {
   requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
      return false;
   }else{
      return true;
   }
}

 @Override
 public void onRequestPermissionsResult(int requestCode, String[]   permissions, int[] grantResults) {
switch (requestCode) {
    case REQUEST_LOCATION_CAMERA:
         if (grantResults[0] == PackageManager.CAMERA) {
                Log.d(TAG,"Premission granted");
         }else {
                Log.d(TAG,"Premission denied");
         }
         break;
}
}