private void GetGCM(final String UserID) {
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Looper.prepare();
                GCMHelper gcmRegistrationHelper = new GCMHelper(getApplicationContext());
                String gcmRegID = "";
                gcmRegID = gcmRegistrationHelper.GCMRegister("123456");

                // Update using Web Service
                try {
                    UpdateGCMWSTask updateGCMWSTask = new UpdateGCMWSTask();


                    updateGCMWSTask.execute(UserID, gcmRegID);
                    // ************ HERE IS THE ERROR ***********************

                }catch (Exception e)
                {
                    e.printStackTrace();
                }

              Looper.loop();
            } catch (Exception bug) {
                bug.printStackTrace();
            }
        }
    });

    thread.start();
}