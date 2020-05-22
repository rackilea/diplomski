Server server = new Server(80);
WebAppContext context = new WebAppContext();
context.setContextPath("/");
ResourceCollection resources = new ResourceCollection(new String[] {
    "project1/src/main/webapp", 
    "project2/src/main/webapp", 
});
context.setBaseResource(resources);
server.setHandler(context);
server.start();