final JDialog waitForTrans = new JDialog((JFrame) null, true);

SwingWorker worker = new SwingWorker() {

  public String doInBackground() throws Exception {
    Thread.sleep(5000);
    return null;
  }

  public void done() {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        waitForTrans.setVisible(false);
        waitForTrans.dispose();
      }
    });
  }

};

worker.execute();
SwingUtilities.invokeLater(new Runnable() {
  public void run() {
    waitForTrans.add(new JLabel("Please Wait..."));
    waitForTrans.setMinimumSize(new Dimension(300, 100));
    waitForTrans.setVisible(true);
  }
});