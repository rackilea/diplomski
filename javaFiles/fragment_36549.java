String serviceUrl = "service:jmx:rmi:///jndi/rmi://localhost:9001/jmxrmi";
JMXServiceURL jmxServiceUrl = new JMXServiceURL(serviceUrl);
JMXConnector jmxc = JMXConnectorFactory.connect(jmxServiceUrl, null);
MBeanServerConnection conn = jmxc.getMBeanServerConnection();
ObjectName name = new ObjectName("Catalina:type=ProtocolHandler,port=8080");
System.out.println(conn.getAttribute(name, "connectionCount"));