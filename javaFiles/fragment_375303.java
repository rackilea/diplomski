PackageManager packageManager = getPackageManager();
ComponentName notificationListenerService = new ComponentName(this,
    YourNotificationListenerService.class);

// The new state of the service - either enabled or disabled
int newState = enableService
    ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED
    : PackageManager.COMPONENT_ENABLED_STATE_DISABLE;

packageManager.setComponentEnabledSetting(
    notificationListenerService,
    newState,
    PackageManager.DONT_KILL_APP);