@Override
   public void userInfo(String firstName, String lastName, String address, String phone) {
   runOnUiThread(new Runnable() {
     public void run() {
       // do something here with your TextView
     }
   });
}