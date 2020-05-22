private void registerPopupItemActionPerformed(java.awt.event.ActionEvent evt) {                                                  

    WaitDialog dialog = new WaitDialog(new javax.swing.JFrame(), true);
    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

    });
    SwingWorker worker = new SwingWorker() {

        @Override
        protected Object doInBackground() throws Exception {
            register();
            return 0;
        }

        @Override
        protected void done() {
            dialog.dispose();
        }
    };
    worker.execute();
    dialog.setVisible(true);
}