ConnectivityManager oncm = (ConnectivityManager)ontext.getSystemService(Context.CONNECTIVITY_SERVICE);

   oncm.startTethering(ConnectivityManager.TETHERING_WIFI, true, new ConnectivityManager.OnStartTetheringCallback() {

   @Override
   public void onTetheringStarted() {
          super.onTetheringStarted();
          Log.i(TAG, "Hotspot is successfully opened");
   }

   @Override
   public void onTetheringFailed() {
          super.onTetheringFailed();
          Log.e(TAG, "Hotspot failed to open");
   }
 });