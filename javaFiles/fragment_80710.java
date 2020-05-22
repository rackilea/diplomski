private void deleteMessage(String messageId, String queueName) {
    try {
         JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
         JMXConnector jmxc = JMXConnectorFactory.connect(url);
         MBeanServerConnection conn = jmxc.getMBeanServerConnection();
         ObjectName name = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost");
         BrokerViewMBean proxy = (BrokerViewMBean)MBeanServerInvocationHandler.newProxyInstance(conn, name, BrokerViewMBean.class, true);
         for (ObjectName queue : proxy.getQueues()) {  
            QueueViewMBean queueBean = (QueueViewMBean) MBeanServerInvocationHandler.newProxyInstance(conn, queue, QueueViewMBean.class, true);
            if(queueBean.getName().equals(queueName)) {
                System.out.println("Deleted : " + messageId);
                queueBean.removeMessage(messageId);
                return;
            }
         }
    } catch(Exception e) {
        e.printStackTrace();
    }
}