//did not use second port. resulted in using random second port
    String url = "service:jmx:rmi://somehost:9010/jndi/rmi://somehost/jmxrmi";
    final JMXConnector jmxConnector = JMXConnectorFactory.connect(url);

    //this worked because now we are using 1 port
    String url="service:jmx:rmi://somehost:9010/jndi/rmi://somehost:9010/jmxrmi";
     final JMXConnector jmxConnector = JMXConnectorFactory.connect(url);