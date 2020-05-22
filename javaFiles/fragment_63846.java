public void onReceive(Context context, Intent intent) {
if(intent == null){
return;
}
String action = intent.getAction();
if (action != null && action.equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")) {
}

AlarmReceiver.completeWakefulIntent(intent);

}