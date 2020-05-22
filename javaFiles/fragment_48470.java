MyInteger i = new MyInteger(9);
i.addListener(new PropertyChangeListener() {
  public void propertyChanged(PropertyChangedEvent e) {
      //implement to process the change - e.g. update your table
      Integer i = (Integer) e.getNewValue();
  }
});