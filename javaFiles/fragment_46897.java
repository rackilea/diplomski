Server server = new Server(8080);
HandlerCollection myhandlers = new HandlerCollection(true);
server.setHandler(myhandlers);

// add some initial handlers
myhandlers.setHandlers(new Handlers[] { helloHandler, indexHandler });

// start server
server.start();

// ... at some point later, during runtime
FooHandler fooHandler = new FooHandler();
fooHandler.start();
myhandlers.addHandler(fooHandler);

BarHandler barHandler = new BarHandler();
barHandler.start();
myhandlers.addHandler(barHandler);