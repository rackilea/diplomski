private boolean checkAndRequestPermissions(){

        //add as much as permission you need
        int readSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        int sendSms = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (readSMS != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_SMS);
        }
        if (receiveSms != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.RECEIVE_SMS);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),
                    REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }