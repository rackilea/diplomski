public int onStartCommand(Intent intent, int flags, int startId)
{
    Log.e(TAG, "onStartCommand");
    super.onStartCommand(intent, flags, startId);
    markerLat = (Double) intent.getExtras().get("latitude");
    markerLon = (Double) intent.getExtras().get("longitude");
    return START_STICKY;
}