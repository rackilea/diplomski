ApplicationAdapter application = new FixInitiator();
SessionSettings settings = new SessionSettings("./config/initiator.cfg");
CustomLogFactory customLogFactory = new CustomLogFactory(settings, myCustomID);
DefaultMessageFactory messageFactory = new DefaultMessageFactory();
FileStoreFactory fileStoreFactory = new FileStoreFactory(settings);
socketInitiator = new SocketInitiator(application, fileStoreFactory, settings, customLogFactory, messageFactory);
socketInitiator.start();