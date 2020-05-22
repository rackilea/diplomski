private boolean canMakeSmores(){

    return(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP_MR1);

}       


 public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults){

    switch(permsRequestCode){

        case 200:

            if(grantResults.length > 0){

                boolean cameraAccepted = grantResults[0]==PackageManager.PERMISSION_GRANTED;

                if(cameraAccepted){

                }else {
                    requestPermissions(perms, permsRequestCode);
                }

                boolean writeAccepted = grantResults[1]==PackageManager.PERMISSION_GRANTED;

                if(writeAccepted){

                }else {
                    requestPermissions(perms, permsRequestCode);
                }

                boolean readAccepted = grantResults[2]==PackageManager.PERMISSION_GRANTED;

                if(readAccepted){

                }else {
                    requestPermissions(perms, permsRequestCode);
                }

                boolean fineLocationAccepted = grantResults[3]==PackageManager.PERMISSION_GRANTED;

                if(fineLocationAccepted){

                }else {
                    requestPermissions(perms, permsRequestCode);
                }

                boolean coarseLocationAccepted = grantResults[4]==PackageManager.PERMISSION_GRANTED;

                if(coarseLocationAccepted){

                }else {
                    requestPermissions(perms, permsRequestCode);
                }

            }

            break;

    }

}