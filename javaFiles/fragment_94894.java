public static void main(String[] args) throws Exception {   
    final Router router = new Router();
    router.attach("/hello", FirstServerResource.class);
    router.attach("/json", Json.class);
    router.attachDefault(Default.class);

    Application myApp = new Application() {
        @Override
        public org.restlet.Restlet createInboundRoot() {
            router.setContext(getContext());                
            return router;
        };
    };


    Component component = new Component();
    component.getDefaultHost().attach("/test", myApp);

    new Server(Protocol.HTTP, 8182, component).start();
}