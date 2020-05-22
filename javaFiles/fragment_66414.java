private BroadcastReceiver myReceiver = new BroadcastReceiver() {
    public void onReceive(android.content.Context context, Intent intent) {
        Log.e("PANKAJ", "Context class " + context.getClass().getName());
        Log.e("PANKAJ", "Activity Context class "
            + MainActivity.this.getClass().getName());
        Log.e("PANKAJ", "Application Context class "
            + context.getApplicationContext().getClass().getName());
    }
};