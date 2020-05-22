public void onResume()
{
    ComponentName component=new ComponentName(this, TextMessageReceiver.class);
    getPackageManager()
        .setComponentEnabledSetting(component,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP);
}

public void onPause()
{
    ComponentName component=new ComponentName(this, TextMessageReceiver.class);
    getPackageManager()
        .setComponentEnabledSetting(component,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP);
}