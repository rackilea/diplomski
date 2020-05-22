@Override
public void run() {
    while (!this.isInterrupted()) { // Exit when thread's interrupt flag is set
        HttpConnection con = new HttpConnection(params, "http://surfkid.redio.de/getChannelState", this.ins);
        con.start();
        try {
            Log.e("Sleep", "Begin");
            UpdateState.this.sleep(5000);
            Log.e("Sleep", "End");
        } catch (InterruptedException e) {
            Log.e("Sleep", "Error");
            e.printStackTrace();

            // Restore interrupt flag after catching InterruptedException
            // to make loop condition false
            Thread.currentThread().interrupt();
        }
    }
}