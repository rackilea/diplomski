for (Network network : connectivityManager.getAllNetworks()) {
  NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
  if (networkInfo.getType() == ConnectivityManager.TYPE_ETHERNET || networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
    connectivityManager.bindProcessToNetwork(network);
    break;
  }
}