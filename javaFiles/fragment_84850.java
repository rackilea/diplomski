public static void main(String[] args) throws Exception {
    Weld weld = new Weld();
    final WeldContainer container = weld.initialize();
    RequestContext requestContext= container.instance().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
    requestContext.activate();

    final MyPojo pojo = container.instance().select(MyPojo.class).get();

    Thread t = new Thread() {
        public void run() {
            RequestContext requestContext= container.instance().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
            requestContext.activate();
            System.out.println("1" + pojo.ping()); 
        }
    };
    t.start();
    t.join();
    System.out.println("2" + pojo.ping());
    weld.shutdown();

}