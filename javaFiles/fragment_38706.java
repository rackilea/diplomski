SwingWorker worker = new SwingWorker() {
    @Override
    public Object construct() {
        // add your code here
        progressBar.setVisible(true);
        progressBar.setIndeterminate(true);
        // and so on...

        return 0;
    }
};
worker.start();