public class Worker extends SwingWorker<Object, Object> {

    @Override
    protected Object doInBackground() throws Exception {

        // The download code would go here...
        for (int index = 0; index < 1000; index++) {

            int progress = Math.round(((float)index / 1000f) * 100f);
            setProgress(progress);

            Thread.sleep(10);

        }

        // You could return the down load file if you wanted...
        return null;

    }
}