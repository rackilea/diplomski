private class MyTextCell  extends AbstractSafeHtmlCell<String> {

 /**
  * Constructs a TextCell that uses a {@link SimpleSafeHtmlRenderer} to render
  * its text.
  */
  public MyTextCell() {
    super(SimpleSafeHtmlRenderer.getInstance(), "click");

  }



  @Override
  public void render(Context context, SafeHtml value, SafeHtmlBuilder sb) {
    if (value != null) {
      sb.append(value);
    }
  }

  @Override
  public void onBrowserEvent(Context context, Element parent,
        String value, NativeEvent event,
        ValueUpdater<String> valueUpdater) {
    GWT.log("Click event!!!!!! Not listening to anything else");
  }
}