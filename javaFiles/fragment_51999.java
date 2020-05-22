private boolean isConnectedToInternet() {
    ConnectivityManager connectivityManager 
          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork= connectivityManager.getActiveNetworkInfo();
    return  activeNetwork != null && activeNetwork.isConnectedOrConnecting();
}