@Override
public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
switch (requestCode) {
    case 0:
        boolean isPerpermissionForAllGranted = false;
        if (grantResults.length > 0 && permissions.length==grantResults.length) {
            for (int i = 0; i < permissions.length; i++){
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    isPerpermissionForAllGranted=true;
                }else{
                    isPerpermissionForAllGranted=false;
                }
            }

            Log.e("value", "Permission Granted, Now you can use local drive .");
        } else {
            isPerpermissionForAllGranted=true;
            Log.e("value", "Permission Denied, You cannot use local drive .");
        }
        if(isPerpermissionForAllGranted){
            // Do your work here
            new Environment(this);
        }
        break;
}