// Define Action.
Action action = new AbstractAction("Do It") {
  public void actionPerformed(ActionEvent e) {
    runBackgroundTask();
  }
}

// Install Action into JButton.
JButton btn = new JButton(action);

private void runBackgroundTask() {
  new SwingWorker<Void, Void>() {
    {
      // Disable action until task is complete to prevent concurrent tasks.
      action.setEnabled(false);
    }

    // Called on the Swing thread when background task completes.
    protected void done() {
      action.setEnabled(true);

      try {
        // No result but calling get() will propagate any exceptions onto Swing thread.
        get();
      } catch(Exception ex) {
        // Handle exception
      }
    }

    // Called on background thread
    protected Void doInBackground() throws Exception {
      // Add ProcessBuilder code here!
      return null; // No result so simply return null.
    }
  }.execute();
}