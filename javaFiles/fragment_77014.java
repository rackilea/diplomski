public static void printUsageStats(List<UsageStats> usageStatsList,Context context, TextView textView){

    for (UsageStats u : usageStatsList) {
        PackageManager pm = context.getPackageManager();
        PackageInfo foregroundAppPackageInfo = null;
        try {
            foregroundAppPackageInfo = pm.getPackageInfo(u.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (u.getTotalTimeInForeground() > 0) {

            textView.setText("Pkg: " + foregroundAppPackageInfo.applicationInfo.loadLabel(pm).toString() + "\t"
                    + String.valueOf(((u.getTotalTimeInForeground() / 60000) / 60) / 24) + "d "
                    + String.valueOf(((u.getTotalTimeInForeground() / 60000) / 60) % 24) + "hr "
                    + String.valueOf((u.getTotalTimeInForeground() / 60000) % 60) + "m "
                    + String.valueOf((u.getTotalTimeInForeground() / 1000) % 60) + "s");
        }
    }
}