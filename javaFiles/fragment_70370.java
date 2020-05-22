@Override
    protected List<Runner> getChildren() {
        ArrayList<Runner> runner = new ArrayList<>(super.getChildren());
        if (NUM_THREADS > 1) {
            Collections.shuffle(runner);
        }
        return runner;
    }