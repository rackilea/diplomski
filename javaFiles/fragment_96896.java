private static int achievementsIntent = 10001;


protected void onActivityResult(int requestCode, int resultCode, Intent data) {

  if (requestCode == achievementsIntent) {
     //you are in your callback
     if (resultCode == GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED) {
         // user logged out from achievements screen
     } 
  }
}