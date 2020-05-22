public class MyXYDataset extends AbstractXYDataset {
  private boolean shown;
  private boolean pendingEvent;

  /**
   * Called when the chart containing this dataset is being displayed
   * (e.g. hook this into a selection listener that listens to tab selection events).
   */
  public void setShown(boolean shown) {
    this.shown = shown;

    if (this.shown && this.pendingEvent) {
      this.pendingEvent = false;
      fireDatasetChanged();
    }
  }

  public void addDatapoint(double x, double y) {
    // TODO: Add to underlying collection.

    if (this.shown) {
      // Chart is currently displayed so propagate event immediately.
      fireDatasetChanged();
    } else {
      // Chart is hidden so delay firing of event but record that we need to fire one.
      this.pendingEvent = true;
    }
  }
}