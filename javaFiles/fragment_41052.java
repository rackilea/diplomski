static class MyWorker extends SwingWorker<String, String> {

    private final JTextArea area;

    MyWorker(JTextArea area) {
        this.area = area;
    }

    @Override
    public String doInBackground() {
        for (int i = 0; i < 100; i++) {
            try { Thread.sleep(10); } catch (InterruptedException e) {}
            publish("Processing... " + i);
        }
        return "Done";
    }
    @Override
    protected void process(List<String> chunks) {
        for (String c : chunks) area.insert(c + "\n", 0);
    }
    @Override
    protected void done() {
        try {
            area.insert(get() + "\n", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}