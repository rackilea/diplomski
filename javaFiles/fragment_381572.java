button.addSelectionListener(new SelectionAdapter() {

   public void widgetSelected(SelectionEvent arg0) {

      statusLabel.setText("Running...");

      Thread background = new Thread() {
         @Override
         public void run() {
            // Long running task

            // Update UI from background thread
            Display.getDefault().asyncExec(() -> statusLabel.setText("Finished"));
         }
      };

      background.start();
  }
});