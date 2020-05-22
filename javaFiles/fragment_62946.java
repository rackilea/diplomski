// Check if there is any connectivity for a Wifi network
public boolean isConnectedWifi(){
    NetworkInfo info = Connectivity.getNetworkInfo(Context);

    if (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI){
    return true;
    }
    return false;
}

// Check if there is any connectivity for a mobile network
public boolean isConnectedMobile(){
    NetworkInfo info = Connectivity.getNetworkInfo(Context);
    if(info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_MOBILE){
    return true;
    }
    return false;
}

// Check all connectivities whether available or not
public boolean isNetworkAvailable() {
    ConnectivityManager cm = (ConnectivityManager) 
      getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = cm.getActiveNetworkInfo();
    // if no network is available networkInfo will be null
    // otherwise check if we are connected
    if (networkInfo != null && networkInfo.isConnected()) {
        return true;
    }
    return false;
}