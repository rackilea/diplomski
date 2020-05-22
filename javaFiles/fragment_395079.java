// !! public method that other classes can call to change tab
public void openNextTab() {
  int selectedIndex = tabpane.getSelectedIndex();
  selectedIndex++;
  selectedIndex %= tabpane.getTabCount();
  tabpane.setSelectedIndex(selectedIndex);
}

//!! needed by JDialog constructor
public JFrame getFrame() {
  return frame;
}