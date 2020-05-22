class Task extends SwingWorker<String, Void> {

    private int counter;
    // private double rate;
    private int max;

    public Task(int max) {
        // Adds the PropertyChangeListener to the ProgressBar
        // addPropertyChangeListener(gui);
        // !!rate = (float)100/max;
        this.max = max;
        setProgress(0);
        counter = 0;
    }

    /** Increments the progress in 1 times the rate based on maximum */
    public void step() {
        counter++;
        int progress = (100 * counter) / max;
        progress = Math.min(100, progress);
        setProgress(progress);
        // setProgress((int)Math.round(counter*rate));
    }

    public int getCounter() {
        return counter;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String doInBackground() throws Exception {
        return null;
    }

    @Override
    public void done() {
      Toolkit.getDefaultToolkit().beep();
      System.out.println("Progress done.");
    }
}