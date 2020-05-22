@Override
protected void onSaveInstanceState(Bundle outState) {       
    super.onSaveInstanceState(outState);
    MobilePushCordovaPluginUtils.onSaveInstanceState(this, outState);
}

@Override
protected void onNewIntent(Intent intent) {     
    super.onNewIntent(intent);
    MobilePushCordovaPluginUtils.onNewIntent(this, intent);
}