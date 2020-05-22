Runnable runnable = new Runnable() {

    @Override
    public void run() {
        if (isRunning) {
            System.out.println("Running.."+finalImageSwitcher+index);
            ...
            handler.postDelayed(this, interval);
        }
    }
};
handler.postDelayed(runnable, interval);