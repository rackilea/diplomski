SwingWorker<?,?> worker = new SwingWorker<Void, String>() {
    @Override
    protected Void doInBackground() throws Exception {
        Thread.sleep(100);
        return null;
    }

    @Override
    protected void done() {
        // event start
        loading.setVisible(false);

        // prompt user input message box //
        int close = JOptionPane.showConfirmDialog(panel,"Are you sure?",
                "Information", JOptionPane.YES_NO_OPTION);

        // await user selection.
        if(close == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
};
worker.execute(); //Execute the worker