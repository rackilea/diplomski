public static boolean checkInternetConnection(Context context) {
    if (context != null) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected() && cm.getActiveNetworkInfo().isConnectedOrConnecting();
        } else {
            return false;
        }
    } else {
        return false;
    }

}