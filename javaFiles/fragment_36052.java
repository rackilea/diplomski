Intent intent1 = new Intent("com.google.zxing.client.android.SCAN");
 List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent1,     
            PackageManager.MATCH_DEFAULT_ONLY);    
        if(list.size() > 0)  
                // Zxing is available 
        else  
           // Zxing is not available