public class BackgroundTask implements Runnable { // extends Thread {

    public void run() {
        for (int i = 0; i < noQueries; i++) {
            runDatabaseQuery(i);
            updateProgress(i);
        }
    }

    private void updateProgress(final int queryNo) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                statusLabel.setText("Query: " + queryNo);
            }
        });
    }
}