ActivityManager actvityManager = (ActivityManager)
this.getSystemService( ACTIVITY_SERVICE );
List<RunningAppProcessInfo> procInfos = actvityManager.getRunningAppProcesses();

for(RunningAppProcessInfo runningProInfo:procInfos){

        Log.d("Running Processes", "()()"+runningProInfo.processName);
}