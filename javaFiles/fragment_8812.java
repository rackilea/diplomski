FocusPanel wrapper = new FocusPanel();
HorizontalPanel panel = new HorizontalPanel();
wrapper.add(panel);
wrapper.addClickHandler(new ClickHandler() {
  @Override
  public void onClick(ClickEvent event) {
    // Handle the click
  }
});

// Add wrapper to the parent widget that previously held panel.