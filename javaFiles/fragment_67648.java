public class JmsDestination implements JmsDestinationMXBean {
    protected JmsDestinationAttributes attrs = new JmsDestinationAttributes(System.getProperty("user.name"));

    public JmsDestinationAttributes getAttributes() {
        return attrs;
    }

    public static void main(String[] args) {
        JmsDestination impl = new JmsDestination();
        try {
            ManagementFactory.getPlatformMBeanServer().registerMBean(impl, new ObjectName("org.jms.impl.test:name=" + impl.attrs.getName()));
            Thread.currentThread().join();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}