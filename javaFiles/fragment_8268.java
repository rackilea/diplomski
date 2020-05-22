abstract class CustomCell extends AbstractCell<String>{

    private MyObject object;
    private Set<String> set ;

    @Override
    public Set<String> getConsumedEvents() {
        set = new HashSet<String>();
        set.add("click");
        return set;
    }

    public void setObject(MyObject object) {
        this.object = object;

    }

    @Override
    public void render(com.google.gwt.cell.client.Cell.Context context,
            String value, SafeHtmlBuilder sb) {
        sb.appendHtmlConstant("<div><label>"+object.getLabel()+"</label><a id='idofthislelement'>"+object.getAnchor()+"</a></div>");
    }

    @Override
    public void onBrowserEvent(Context context, Element parent,
            String value, NativeEvent event,
            ValueUpdater<String> valueUpdater) {
        super.onBrowserEvent(context, parent, value, event, valueUpdater);

        if ("click".equals(event.getType())) {
            EventTarget eventTarget = (EventTarget) event.getEventTarget();
            Element targetElement = Element.as(eventTarget);
            if (parent.getFirstChildElement().isOrHasChild(targetElement)&&targetElement.getId().equals("idofthislelement")) {
                doAction(value, valueUpdater,object);
            }
        }
    }

    protected abstract void doAction(String value, ValueUpdater<String> valueUpdater,MyObject object);