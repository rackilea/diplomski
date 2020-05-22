final Button button = new Button(shell, SWT.PUSH);

button.addSelectionListener(new SelectionListener() {

  public void widgetSelected(SelectionEvent event) {
    controller.handleWidgetSelectedEvent(event); // controller decides what to do...
  }

  public void widgetDefaultSelected(SelectionEvent event) {
    controller.handleWidgetDefaultSelectedEvent(event); // controller decides what to do...
  }
});