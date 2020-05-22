public static void setIpAssignment(String assign, WifiConfiguration wifiConf)
        throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        Object ipConfiguration = wifiConf.getClass().getMethod("getIpConfiguration").invoke(wifiConf);
        setEnumField(ipConfiguration, assign, "ipAssignment");
    } else {
        setEnumField(wifiConf, assign, "ipAssignment");
    }
}