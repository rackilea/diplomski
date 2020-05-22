AccessibilityManager am = (AccessibilityManager)
                                   getSystemService(ACCESSIBILITY_SERVICE);

List<AccessibilityServiceInfo> listOfServices = 
                                 am.getEnabledAccessibilityServiceList(
                                   AccessibilityServiceInfo.FEEDBACK_ALL_MASK);

for (AccessibilityServiceInfo asi : listOfServices) {
    Log.i("", "Accessibility Service >>>>>>>>: " + asi.getSettingsActivityName());
Log.i("", "Accessibility Service >>>>>>>>: " +
                                 asi.loadDescription(getPackageManager()));

}