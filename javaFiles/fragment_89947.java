final Router router = new Router();
router.attachDefault(HttpListener.class);

MySharedObj myobj = MySharedObj.newInstance();

org.restlet.Application myApp = new org.restlet.Application() {
    @Override
    public org.restlet.Restlet createInboundRoot() {
        return router;
    };
};
Component component = new Component();
component.getDefaultHost().attach("/", myApp);

new Server(Protocol.HTTP, port, component).start();

// in a different thread
MySharedObj myobj = MySharedObj.get();
myobj.doStuff()