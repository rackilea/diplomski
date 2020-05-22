Handler handler = new Handler() {
      @Override
       public void handleMessage(Message msg) {
       super.handleMessage(msg);
         // dismiss the progress dialog
      }
    };
 HttpAsyncTask asyncTask = new HttpAsyncTask(handler);
 asyncTask.execute();