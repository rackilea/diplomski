public static boolean isInternetAvailable(Context context) { 
boolean result = false; 
ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    if (cm != null) {
        NetworkCapabilities capabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                result = true;
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                result = true;
            }
        }
    }
} else {
    if (cm != null) {
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                result = true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                result = true;
            }
        }
    }
}
return result;
}