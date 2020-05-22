static void disable(final AbstractButton b, final long ms) {
    b.setEnabled(false);
    new SwingWorker() {
        @Override protected Object doInBackground() throws Exception {
            Thread.sleep(ms);
            return null;
        }
        @Override protected void done() {
            b.setEnabled(true);
        }
    }.execute();
}