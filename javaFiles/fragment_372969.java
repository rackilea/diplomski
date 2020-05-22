FtpServerFactory serverFactory = new FtpServerFactory();

ListenerFactory listenerFactory = new ListenerFactory();
listenerFactory.setPort(port);
listenerFactory.setServerAddress("10.10.10.10");
serverFactory.addListener("default", listenerFactory.createListener());