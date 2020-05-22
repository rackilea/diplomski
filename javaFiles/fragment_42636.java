private boolean isMyServiceRunning(String className) {
ActivityManager manager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
    if (className.equals(service.service.getClassName())) {
        return true;
    }
}
return false;}