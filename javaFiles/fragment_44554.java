final VerticalPanel vp = new VerticalPanel();
vp.add(mainPanel);
vp.setWidth("100%");
vp.setHeight(Window.getClientHeight() + "px");
Window.addResizeHandler(new ResizeHandler() {

  public void onResize(ResizeEvent event) {
    int height = event.getHeight();
    vp.setHeight(height + "px");
  }
});
RootPanel.get().add(vp);