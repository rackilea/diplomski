new SwingWorker<Void, String>() {
  // Called by the background thread.
  public Void doInBackground() {
    for (int i=0; i<100; ++i) {
      // Do work.  Periodically publish String data.
      publish("Job Number: " + i);
    }
  }

  // Called on the Event Dispatch Thread.
  @Override
  protected void process(List<String> chunks) {
    // Update label text.  May only want to set label to last
    // value in chunks (as process can potentially be called
    // with multiple String values at once).
    for (String text : chunks) {
      label.setText(text);
    }
  }  
}.execute();