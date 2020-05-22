public class MyServlet extends VaadinServlet implements SessionInitListener {
    //...

    @Override
    public void sessionInit(SessionInitEvent event) throws ServiceException {
        event.getSession().addBootstrapListener(MyBootstrapListener.INSTANCE);
    }

    private static class MyBootstrapListener implements BootstrapListener {
        private static final long serialVersionUID = 1L;
        private static final MyBootstrapListener INSTANCE = new MyBootstrapListener();

        @Override
        public void modifyBootstrapPage(BootstrapPageResponse response) {
            //...
        }

        @Override
        public void modifyBootstrapFragment(BootstrapFragmentResponse response) {
            //...
        }

        private Object readResolve() {
            return INSTANCE;
        }
    });
}