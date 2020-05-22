final Class<?> conmanClass = Class.forName(GlobalService.getConnectivityService(context).getClass().getName());
final Field iConnectivityManagerField = conmanClass.getDeclaredField("mService");
iConnectivityManagerField.setAccessible(true);
final Object iConnectivityManager = iConnectivityManagerField.get(GlobalService.getConnectivityService(context));
final Class<?> iConnectivityManagerClass = Class.forName(iConnectivityManager.getClass().getName());
final Method[] methods = iConnectivityManagerClass.getDeclaredMethods();
for (final Method method : methods) {
    if (method.toGenericString().contains("set")) {
        Log.i("TESTING", "Method: " + method.getName());
    }
}