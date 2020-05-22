String android_id = Secure.getString(getApplicationContext()
            .getContentResolver(), Secure.ANDROID_ID);
    Log.i("System out", "android_id : " + android_id);

    final TelephonyManager tm = (TelephonyManager) getBaseContext()
            .getSystemService(Context.TELEPHONY_SERVICE);

    final String tmDevice, tmSerial, androidId;
    tmDevice = "" + tm.getDeviceId();
    Log.i("System out", "tmDevice : " + tmDevice);
    tmSerial = "" + tm.getSimSerialNumber();
    Log.i("System out", "tmSerial : " + tmSerial);
    androidId = ""
            + android.provider.Settings.Secure.getString(
                    getContentResolver(),
                    android.provider.Settings.Secure.ANDROID_ID);

    UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice
            .hashCode() << 32)
            | tmSerial.hashCode());
    String UUID = deviceUuid.toString();
    Log.i("System out", "UUID : " + UUID);