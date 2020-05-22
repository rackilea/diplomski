private static boolean isWifiLocationEnabled (Context context) {
    ContentResolver cr = context.getContentResolver();
    String enabledProviders = Settings.Secure.getString(cr, Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
    if (!TextUtils.isEmpty(enabledProviders)) {
        // not the fastest way to do that :)
        String[] providersList = TextUtils.split(enabledProviders, ",");
        for (String provider : providersList) {
            if (LocationManager.NETWORK_PROVIDER.equals(provider)) {
                return true;
            }
        }
    }
    return false;
}