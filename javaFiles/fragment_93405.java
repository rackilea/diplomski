SwingWorker<Void, Integer> testTask = new SwingWorker<Void, Integer>() {

    private int k;

    private void inc() {
        this.k++;
    }

    private void innerLoop(int i) {
        for (int j=0; j<100000; j++) {
            if (i==j && i%10000 == 0)
                this.inc();
        }
    }

    @Override
    protected Void doInBackground()
    throws Exception {
        System.out.println("Started");
        for (int i=0; i<200000; i++) {
            this.innerLoop(i);
        }
        System.out.println(k+" "+(System.currentTimeMillis()-start));
        return null;
    }
};