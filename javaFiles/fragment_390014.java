public class MaintainanceListener extends AbstractRequestCycleListener {

    @Override
    public void onRequestHandlerResolved(RequestCycle cycle, IRequestHandler handler) {
        super.onRequestHandlerResolved(cycle, handler);
        if (handler instanceof IPageRequestHandler && isMaintainanceMode()) {
            final Class<? extends IRequestablePage> pageClass = ((IPageRequestHandler) handler).getPageClass();
            if (MaintenancePage.class != pageClass) {
                final MySession session = MySession.get();
                if (session.getUser() != null) {
                    session.invalidateNow();
                }
                cycle.setResponsePage(MaintenancePage.class);
            }
        }
    }
}