SwingWorker<String, String> task = new SwingWorker<String, String>(){
    private int count = 1;

    @Override
    public List<Integer> doInBackground() throws Exception {
        while (!isCancelled()) {
            for (int i = 0; i < 100000; ++i) {
                publish(count + "");
                ++count;
                Thread.sleep(10); // milliseconds
            }
        }
        return count + "";
    }

    @Override
    protected void process(List<Integer> chunks) {
        gui.setText(chunk.get(chunk.size() - 1));
    }

    @Override
    protected void done() {
        try {
            gui.setText(this.get());
        } catch(InterruptedException | ExecutionException ex) {
            ex.printSTackTrace();
        }
    }
}
task.execute();

// Later:

task.cancel(false);