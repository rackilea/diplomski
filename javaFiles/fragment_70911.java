new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            removeMessage(mContext, "From_number");
        } catch (InterruptedException e) {
            e.printStackTrace();
             }