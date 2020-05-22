public static boolean checkInternetConnection(Context context) {

    ConnectivityManager conMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

    // ARE WE CONNECTED TO THE NET?
    if (conMgr.getActiveNetworkInfo() != null
            && conMgr.getActiveNetworkInfo().isAvailable()
            && conMgr.getActiveNetworkInfo().isConnected()) {
        return true;
    } else {
        Log.w(TAG, "Internet Connection NOT Present");
        return false;
    }
}
    public static boolean isConnAvailAndNotRoaming(Context context) {

    ConnectivityManager conMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

    if (conMgr.getActiveNetworkInfo() != null
            && conMgr.getActiveNetworkInfo().isAvailable()
            && conMgr.getActiveNetworkInfo().isConnected()) {

        if(!conMgr.getActiveNetworkInfo().isRoaming())
            return true;
        else
            return false;
    } else {
        Log.w(TAG, "Internet Connection NOT Present");
        return false;
    }
}
    public static boolean isRoaming(Context context) {

    ConnectivityManager conMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

    return (conMgr.getActiveNetworkInfo()!=null && conMgr.getActiveNetworkInfo().isRoaming());
}