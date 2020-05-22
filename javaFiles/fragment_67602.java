if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
  {
      if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission. CAMERA) == PackageManager.PERMISSION_GRANTED) {
      //  you can access camera   
      } 
      else
      {
         ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission. CAMERA}, 411);
      }
  }
  else
  {
    //  you can access camera          
  }