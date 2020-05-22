Label label = new Label();
label.addDomHandler(new MouseOverHandler() {
  @Override
  public void onMouseOver(MouseOverEvent event) {
    // do something
  }
}, MouseOverEvent.getType());
RootPanel.get().add(label);