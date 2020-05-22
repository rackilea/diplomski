runOnUiThread(new Runnable() {
   @Override
   public void run() {
       ArrayList<Users_fancystock> users = parseJSON(data);
       addData(users);
   }
});