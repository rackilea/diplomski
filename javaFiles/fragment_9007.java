public void actionPerformed(ActionEvent e) {
    setEnabled(false);
    Object creator;
    new FileWriterWorker(creator, url.getText(), new FileWriterWorker.Response() {
        @Override
        public void failure(FileWriterWorker.BackgroundException ex) {
            setEnabled(true);
            Throwable bgCause = ex.getCause();
            if (bgCause instanceof InterruptedException) {
                logger.log(Level.INFO, "Thread interupted, process aborting.", bgCause);
                Thread.currentThread().interrupt();
            }
            else if (cause instanceof ExecutionException) {
                Throwable cause = bgCause.getCause() == null ? bgCause : bgCause.getCause();
                logger.log(Level.SEVERE, "An exception occurred that was "
                    + "not supposed to happen.", cause);
                JOptionPane.showMessageDialog(FileInputFrame.this, "Error: "
                    + cause.getClass().getSimpleName() + " "
                    + cause.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void success(File f) {
            setEnabled(true);
            JOptionPane.showMessageDialog(FileInputFrame.this,
                "File has been retrieved and saved to:\n"
                + file.getAbsolutePath());
            try {
                Desktop.getDesktop().open(file);
            }
            catch (IOException iOException) {
                logger.log(Level.INFO, "Unable to open file for viewing.", ex);
            }
        }
    }).execute();
}