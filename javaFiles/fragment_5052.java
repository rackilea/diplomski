public void actionPerformed(ActionEvent e) {
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
        @Override
        public Void doInBackground() {
            // Call complicated code here
            return null;
            // If you want to return something other than null, change
            // the generic type to something other than Void.
            // This method's return value will be available via get() once the
            // operation has completed.
        }

        @Override
        protected void done() {
            // get() would be available here if you want to use it
            myButton.setText("Done working");
        }
    };
    myButton.setText("Working...");
    worker.execute();
}