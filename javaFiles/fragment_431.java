if (isNetworkEnabled) {
    if (androidLocationManager == null) {
        androidLocationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER, 0, 0,
                saveToSharedPrefListener);
        Log.d(MyLogger.TAG, "Network Enabled");
    }
}