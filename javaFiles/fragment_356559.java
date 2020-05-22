int jmxPort = 1919;
LocateRegistry.createRegistry(jmxPort);

MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
// or: MBeanServer beanServer = MBeanServerFactory.createMBeanServer(); // doesn't register the default platform MBeans

JMXServiceURL jmxUrl 
    = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + jmxPort + "/jmxrmi");
JMXConnectorServer connectorServer
    = JMXConnectorServerFactory.newJMXConnectorServer(jmxUrl, null, beanServer);

connectorServer.start();