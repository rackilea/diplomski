public boolean isForeground(String myPackage) {
    ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
    List<ActivityManager.RunningTaskInfo> runningTaskInfo = manager.getRunningTasks(1); 
    ComponentName componentInfo = runningTaskInfo.get(0).topActivity;
    return componentInfo.getPackageName().equals(myPackage);
}