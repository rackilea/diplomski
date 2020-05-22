@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    if("RESET".equals(intent.getAction()) {
        // do the reset here
        resetWaypoints();
    }

}