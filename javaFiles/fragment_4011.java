class AccordianPanel extends JPanel {
  boolean movingComponents = false;
  int visibleIndex = 3;
  public AccordianPanel() {
    //...
  }
  @Override public boolean isOptimizedDrawingEnabled() {
    return false;
  }