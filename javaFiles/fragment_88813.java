public static String getAppNameByPID(Context context, int pid){
    ActivityManager manager 
               = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

    for(RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()){
        if(processInfo.pid == pid){
            return processInfo.processName;
        }
    }
    return "";
}