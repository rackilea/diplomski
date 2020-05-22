public class SelectableTextCell
extends ClickableTextCell
{
  @Override
  public void onBrowserEvent(
    Context context,
    Element parent,
    String value,
    NativeEvent event,
    ValueUpdater<String> valueUpdater)
  {
    GWT.log("event="+event.getType()); //$NON-NLS-1$
    doYourThing();
    if (IWishToPropagateTheClick)
      super.onBrowserEvent(context, parent, value, event, valueUpdater);
  }
}