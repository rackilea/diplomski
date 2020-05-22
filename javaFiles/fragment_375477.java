if (currentapiVersion <= 16)
{
    Settings.System.putInt(this.getContentResolver(),Settings.System.STAY_ON_WHILE_PLUGGED_IN, BatteryManager.BATTERY_PLUGGED_USB);
}
else
{   
  Settings.Global.putInt(this.getContentResolver(),Settings.Global.STAY_ON_WHILE_PLUGGED_IN, BatteryManager.BATTERY_PLUGGED_USB);
}