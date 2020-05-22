public class MyServlet extends VaadinServlet implements SessionInitListener {
    //...

    @Override
    public void sessionInit(SessionInitEvent event) throws ServiceException {
        event.getSession().addBootstrapListener(new BootstrapListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void modifyBootstrapPage(BootstrapPageResponse response) {
                //...
            }

            @Override
            public void modifyBootstrapFragment(BootstrapFragmentResponse response) {
                //...
            }
        });
    }
}