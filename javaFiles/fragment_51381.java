Runnable runnable = new Runnable() {
    @Override
    public void run() {
        //update UI here

        handler.postDelayed(this, 100);
    }
};
runnable.run()