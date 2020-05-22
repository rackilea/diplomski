public class MyUI extends UI implements PortletListener {

    private static final long serialVersionUID = -1708010797368609962L;
    private VerticalLayout content = new VerticalLayout();

    @Override
    protected void init(VaadinRequest request) {
        VaadinPortletSession session = (VaadinPortletSession) VaadinPortletSession.getCurrent();
        session.addPortletListener(this);
        content.addComponent(new MyCustomScreen());
        setContent(content);
    }

    private void reloadPage() {
        content.removeAllComponents();
        content.addComponent(new MyCustomScreen());
    }

    @Override
    public void handleRenderRequest(RenderRequest request, RenderResponse response, UI uI) {
        accessSynchronously(this::reloadPage);
    }

    @Override
    public void handleActionRequest(ActionRequest request, ActionResponse response, UI uI) {
    }

    @Override
    public void handleEventRequest(EventRequest request, EventResponse response, UI uI) {
    }

    @Override
    public void handleResourceRequest(ResourceRequest request, ResourceResponse response, UI uI) {
    }       
}