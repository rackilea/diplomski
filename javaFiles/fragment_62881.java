protected void onPostExecute(String file_url) {

     Handler handler = new Handler();
     handler.postDelayed(new Runnable()
        {
        @Override
        public void run() 
           {
            Send_sms();
           }
        }, 20000); //Time Delay
      }