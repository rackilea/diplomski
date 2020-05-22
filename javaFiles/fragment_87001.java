@Override
public void onServiceConnected() {
    AccessibilityServiceInfo config = getServiceInfo();//This IS A REALLY IMPORTANT CHANGE!!! 
    //By instantiating a new "AccessibilityServiceInfo" you have overwritten all of your XML Config changes, as well as any default settings internal to Android! 
    //DON'T instantiate your own ServiceConfig objects!!!! Just don't. In fact, do everything in XML instead!

    config.eventTypes = AccessibilityEvent.TYPE_WINDOWS_CHANGED;
    config.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;

    config.flags = AccessibilityServiceInfo.FLAG_INCLUDE_NOT_IMPORTANT_VIEWS;

    setServiceInfo(config);
    super.onServiceConnected();
}