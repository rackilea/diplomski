public class Funzioni { 
        public String checkimei(Context context) { 
        String IMEINumber = ""; 
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) { 
            TelephonyManager telephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE); 
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { 
                IMEINumber = telephonyMgr.getImei(); 
            } else { 
               IMEINumber = telephonyMgr.getDeviceId(); 
            } 
        } 
        return IMEINumber;
     } 
}