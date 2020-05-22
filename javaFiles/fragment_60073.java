public class LoadMaster extends SwingWorker<Void, Progress> {

    @Override
    protected Void doInBackground() throws Exception {
        System.out.println("Working hard here, nothing to see...");
        for (int index = 0; index < 100; index++) {
            Thread.sleep(10);
            setProgress(index);
        }
        return null;
    }

    @Override
    protected void done() {
        try {
            get();
        } catch (Exception e) {
        }
    }

}