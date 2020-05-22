public void onReceive(Context context, Intent intent) {

  if(intent.getAction().equals("broad.cast.action.visibility")){
     buttonVisibility = intent.getStringExtra("visibility");

        switch (buttonVisibility) {
            case "visible":
                showButtonMatikanAlarm();
                break;
            case "gone":
                hideButtonMatikanAlarm();
                break;
            default:
                //do nothing
                break;
        }
 }
}