public class SeoClickableCell extends AbstractCell<String> {

public SeoClickableCell() {
    super("click", "keydown");
}

@Override
public void render(com.google.gwt.cell.client.Cell.Context context, String value, SafeHtmlBuilder sb) {
     if (value != null) {
         sb.appendHtmlConstant("<a href='javascript:;'>");
         sb.appendEscaped(value);
         sb.appendHtmlConstant("</a>");
     }
}

@Override
public void onBrowserEvent(com.google.gwt.cell.client.Cell.Context context, Element parent, String value, NativeEvent event, ValueUpdater<String> valueUpdater) {
    if (value == null)
        return;

    super.onBrowserEvent(context, parent, value, event, valueUpdater);
    if ("click".equals(event.getType())) {
        //TODO
    }
}