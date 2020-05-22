@PostConstuct 
    private void registerToJMX() {
       private MBeanServer platformMBeanServer;
       private ObjectName objectName = null;
       try {
           objectName = new ObjectName("tms:name=BlankNotifications");
           platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
           platformMBeanServer.registerMBean(this, objectName);
       } catch (Exception e) {            
       }
    }