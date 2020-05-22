widget = uiBinder.createAndBindUi(this);               // everything's bound

accordionLayoutContainer.setActiveWidget(firstPanel);  // OK, expands first pane
accordionLayoutContainer.addAttachHandler(new AttachEvent.Handler() {

  @Override
  public void onAttachOrDetach(AttachEvent event) {
    clientsTree.getSelectionModel().select(mynode, true);
    clientsTree.setExpanded(mynode, true);              
  }
});