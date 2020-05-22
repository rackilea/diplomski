protected void onHandleWork(@NotNull Intent intent) {

     // 
     Intent intent = new Intent(this, BackgroundService.class)
     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
         startForegroundService(intent)
     } else {
         startService(intent)
     }
}