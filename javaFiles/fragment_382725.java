Hi thread is stop by kill() or stop() or destroy method of thread but this all are              
deprecated so dont kill the thread thread is automatically destroy after done its work.   
 so   
if you want to do any work use handler like this not thread in therad.
new Thread() {

        public void run() {

            try {
                Message msg = new Message();
                msg.arg2 = 0;
                handle.sendMessage(msg);
                Thread.sleep(5000);
            } catch (Exception e) {
                Log.e("tag", e.getMessage());
            }

            //

        }

    }.start();
 and make handler in ur activity like this
 public static Handler handle = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (msg.arg2 == 0) {
            Toast.makeText(context, "No data to sync.",    
  Toast.LENGTH_SHORT)
                    .show();
        } else if (msg.arg2 == 1) {
            Toast.makeText(context, "Data Sync Completed.",
                    Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "Data Sync not Completed.",
                    Toast.LENGTH_SHORT).show();
        }

    }
};