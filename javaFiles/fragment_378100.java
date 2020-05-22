@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
       if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
          Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
          //resume tasks needing this permission
      }
   }