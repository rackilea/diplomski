class Solver  extends SwingWorker<Integer, Integer> {
    int delay;

    Solver (int delay) {
        this.delay = delay;
    }

    protected Integer doInBackground() throws Exception {
        scene.solve(delay);
        return 1;
    }
}