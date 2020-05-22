if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // ask user permission 
        } else {
   // READ_PHONE_STATE permission is already been granted.
            TelephonyManager mngr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
            IMEI = mngr.getDeviceId();                    
        }