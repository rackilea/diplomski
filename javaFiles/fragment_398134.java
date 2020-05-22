public void onClick(View view) {

            String CheckGCMID;
            GetGCM(new MyCallback(){
                @Override
                public void receivedString(String myString) {
                    //use your id here
                    System.out.println(myString);
                }
            });

  }


private interface MyCallback{
    public void receivedString(String myString);
}

private void GetGCM(MyCallback callback) {
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                GCMHelper  gcmRegistrationHelper = new GCMHelper (getApplicationContext());
                String gcmRegID = gcmRegistrationHelper.GCMRegister("123456");
                callback.receivedString(gcmRegID);
            } catch (Exception bug) {
                bug.printStackTrace();
            }

        }
    });
    thread.start();
}