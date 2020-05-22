class MyWorker extends SwingWorker<Integer[], String> {

    private int quadrant;
    private boolean zoomed;

    public MyWorker(int quadrant, boolean zoomed) {
        this.quadrant = quadrant;
        this.zoomed = zoomed;
    }

    @Override
    protected Integer[] doInBackground() throws Exception {
        Integer[] zoomData = new Integer[4];

        // use quadrant && zoomData...
        publish("Intermediate data...");
        ...

        publish("complete");
        return zoomData;
    }
};