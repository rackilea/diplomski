final JLabel label;
class MeaningOfLifeFinder extends SwingWorker<String, Object> {
  @Override
  public String doInBackground() {
    // Here you do the work of your thread
    return findTheMeaningOfLife();
  }

  @Override
  protected void done() {
    // Here you notify the GUI
    try {
      label.setText(get());
    } catch (Exception ignore) {
    }
  }
}