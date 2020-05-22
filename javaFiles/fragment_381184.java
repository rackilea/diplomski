@Override
   protected void onNewIntent(Intent intent) {
       super.onNewIntent(intent);
       if ("action.action.myactionstring".equals(intent.getAction())) {
           finish();
       }
   }