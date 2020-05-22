public boolean isOnline(Context context) {

    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    //should check null because in airplane mode it will be null
    return (netInfo != null && netInfo.isConnected());

}