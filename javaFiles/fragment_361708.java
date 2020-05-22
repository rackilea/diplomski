@Override
        public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
// READ_PHONE_STATE permission is already been granted.
                TelephonyManager mngr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
                IMEI = mngr.getDeviceId();  
    }
    }