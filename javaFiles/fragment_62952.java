// this method will return either
// ConnectivityManager.TYPE_MOBILE
// or
// ConnectivityManager.TYPE_WIFI
// or -1 (if no connection is available)
private int checkAvailableConnectionType() {
    ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
    int type = activeNetwork.getType();
    if(activeNetwork.isConnected() && (type == ConnectivityManager.TYPE_MOBILE ||
            type == ConnectivityManager.TYPE_WIFI)) {
        return type;
    }
    return -1;
}