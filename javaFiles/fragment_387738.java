ConnectivityManager conMgr =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

if ( conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED 
    ||  conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING  ) {
...
}