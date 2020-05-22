@Override
protected void onCreate(Bundle bundle) {
   super.onCreate(bundle);

   if (isLargeDevice(getBaseContext())) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
   } else {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
   }
}