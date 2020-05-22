@Override
protected void onMessage(Context context, Intent intent) {
    Log.i(TAG, "Ontvangen bericht");
    String message = intent.getExtras().getString("price");

    displayMessage(context, message);
    // notifies user
    generateNotification(context, message);
}