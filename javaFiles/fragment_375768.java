this.setVisible(true);

    worker do_work = new worker(this);
    do_work.execute();
}

class worker extends SwingWorker<String, Object> {
    private SplashScreen parent;

    public worker(SplashScreen parent) {
        this.parent = parent;
    }

    @Override
    public String doInBackground() {
        try
        {
            Thread.sleep(TEMP_AFFICHAGE);
        }
        catch (InterruptedException ex)
        {
            ApplicationLogger.getInstance().severe(ex.getLocalizedMessage());
        }
        return "";
    }

    @Override
    protected void done() {
        parent.setVisible(false);
    }
};