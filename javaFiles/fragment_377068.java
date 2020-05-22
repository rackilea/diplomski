void updateJavaScriptEnabled(boolean enabled) {
    if (isAccessibilityInjectionEnabled()) {

 ==>>>> // Call placed to AccessibilityInjector.updateJavaScriptEnabled(boolean)
        getAccessibilityInjector().updateJavaScriptEnabled(enabled);
    }
}