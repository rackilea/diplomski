public static boolean isConnected(Context context) {
    ConnectivityManager connectivityManager = (ConnectivityManager)
        context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = null;
    if (connectivityManager != null) {
        networkInfo = connectivityManager.getActiveNetworkInfo();
    }

    return networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED;
}