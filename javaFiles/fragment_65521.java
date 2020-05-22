ItemListener itemListener = new ItemListener() {
  public void itemStateChanged(ItemEvent itemEvent) {
    int state = itemEvent.getStateChange();
    if (state == ItemEvent.SELECTED) {
      System.out.println("Selected");
    } else {
      System.out.println("Deselected");
    }
  }
};