//Verifica as permissões do aplicativo
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_ACCESS_FINE_LOCATION: {
                // Coloca as permissões em ordem e checa se elas estão habilitadas.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                     if (mMap!=null && checkPermissions()) {
                          mMap.setMyLocationEnabled(true);
                      }

                    //Se aplicativo não foi permitido depois de perguntar, o fecha
                } else {
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
                return;
            }
        }
    }