BackgroundTask task = new BackgroundTask(new ProgressListener() {
    @Override
    public void report(String step) {
        label.setText(step);
    }
});