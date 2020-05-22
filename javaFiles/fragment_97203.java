Intent intent = new Intent(context, LocationReceiver.class);
intent.setAction("myBroadcast");
intent.putExtra("session_id", session_id);
PendingIntent lpendingIntent = PendingIntent.getBroadcast(activity.getApplicationContext(), 58534, intent, PendingIntent.FLAG_UPDATE_CURRENT);

//Unregister for broadcast intents
LocationManager locationManager  = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
locationManager.removeUpdates(lpendingIntent);