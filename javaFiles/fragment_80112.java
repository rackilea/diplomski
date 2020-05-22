private static final String OLD_TAB_INDEX_PROPERTY = "oldTabIdx";

tabbedPane.addChangeListener(new ChangeListener() {
  public void stateChanged(ChangeEvent e) {
    JTabbedPane tabP = (JTabbedPane) e.getSource();
    int currIndex = tabP.getSelectedIndex();

    int oldIdx = 0;
    Object old = tabP.getClientProperty(OLD_TAB_INDEX_PROPERTY);
    if (old instanceof Integer) {
      oldIdx = (Integer) old;
    }
    tabP.putClientProperty(OLD_TAB_INDEX_PROPERTY, currIndex);
    // now we can use old and current index
  }
});