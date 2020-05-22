//Requesting permission
  private void requestSmsSendPermission() {

    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
      //If the user has denied the permission previously your code will come to this block
      //Here you can explain why you need this permission
      //Explain here why you need this permission
    }

    //And finally ask for the permission
    ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.SEND_SMS },
      SEND_SMS_CODE);
  }