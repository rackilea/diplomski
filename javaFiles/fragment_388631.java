MBeanServer mBeanServer = MBeanServerFactory.findMBeanServer(null).get(0);
    ObjectName name = new ObjectName("Catalina", "type", "Server");
    Server server = (Server) mBeanServer.getAttribute(name, "managedResource");
    Service service = server.findService("Catalina");
    Engine engine = (Engine) service.getContainer();
    Host host = (Host) engine.findChild(engine.getDefaultHost());

    host.getAppBase(); //Got it.