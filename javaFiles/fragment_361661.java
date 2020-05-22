private void getPackageSizeInfo(Context context, String packageName) {
    try {
        PackageManager packageManager = context.getPackageManager();
        Method getPackageSizeInfo = packageManager.getClass().getMethod("getPackageSizeInfo", String.class, IPackageStatsObserver.class);

        getPackageSizeInfo.invoke(packageManager, packageName, new IPackageStatsObserver.Stub() {
            public void onGetStatsCompleted(PackageStats packageStats, boolean succeeded) throws RemoteException {
                long totalCacheSize = packageStats.cacheSize + packageStats.externalCacheSize;
                long totalDataSize = packageStats.dataSize + packageStats.externalDataSize;
                long totalCodeSize = packageStats.codeSize + packageStats.externalCodeSize;
                long totalSize = totalDataSize + totalCodeSize;

                Log.d(TAG, "Total Size:" + totalSize);
                Log.d(TAG, "App Size:" + totalCodeSize);
                Log.d(TAG, "Data Size:" + totalDataSize);
                Log.d(TAG, "Cache Size:" + totalCacheSize);
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
}