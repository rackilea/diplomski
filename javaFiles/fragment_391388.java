public static boolean isNetworkAvailable(Context context)
{
    ConnectivityManager connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (connectivity == null) {
        Log.w("tag", "Connectivity Manager failed to retrieve.");
    } else {
        NetworkInfo[] info = connectivity.getAllNetworkInfo();
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
    }
    return false;
}