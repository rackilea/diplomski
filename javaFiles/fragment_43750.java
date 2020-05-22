JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
JMXConnector connector = JMXConnectorFactory.connect(url, null);
connector.connect();
connection = connector.getMBeanServerConnection();
ObjectName name = new ObjectName(getObjectNameByBrokerName(brokerName));
brokerMBean = (BrokerViewMBean) MBeanServerInvocationHandler.newProxyInstance(connection, name, BrokerViewMBean.class, true);

ObjectName[] objNames = brokerMBean.getQueues();
for (ObjectName objName : objNames) {
    QueueViewMBean queueMBean = (QueueViewMBean) MBeanServerInvocationHandler.newProxyInstance(connection, objName, QueueViewMBean.class, true);
    System.out.println(queueMBean.getName());
}