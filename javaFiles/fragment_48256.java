private Runnable runnable = new Runnable() {
    @Override
    public void run() {
        try{
            //Start your intent service here.
        } finally {
            handler.postDelayed(runnable, 60000);
        }
    }
};