public class AttachAPIExample {

    /**
     * Uses the attach API to locate all JVMs accessible on this machine.
     * @param args None
     */
    public static void main(String[] args) {
        // Get my PID
        final String MYPID = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        log("Scanning for JVMs...");
        // List all the Virtual Machine Descriptors
        List<VirtualMachineDescriptor> descriptors = VirtualMachine.list(); 
        for(VirtualMachineDescriptor vmd: descriptors) {
            VirtualMachine vm = null;
            // Do this in a catch block in case we run into a JVM that is not the same "bit" as we are
            try {
                vm = vmd.provider().attachVirtualMachine(vmd.id());
                String display = vmd.displayName().trim().isEmpty() ? "Unknown" : vmd.displayName();
                log("JVM%sPID: %s Display: %s", vmd.id().equals(MYPID) ? " (Me) " : " ", vmd.id(), display);
                String connectorAddress = vm.getAgentProperties().getProperty("com.sun.management.jmxremote.localConnectorAddress", null);
                if(connectorAddress!=null) {
                    log("\tConnector Found Installed at [%s]", connectorAddress);
                } else {
                    String javaHome = vm.getSystemProperties().getProperty("java.home");
                    File agentJarFile = new File(javaHome + File.separator + "lib" + File.separator + "management-agent.jar");
                    if(agentJarFile.exists()) {
                        log("I think we can find this JVM's management agent here: [%s]", agentJarFile.toString());
                        vm.loadAgent(agentJarFile.getAbsolutePath());
                        connectorAddress = vm.getAgentProperties().getProperty("com.sun.management.jmxremote.localConnectorAddress", null);
                        log("\tConnector Installed at [%s]", connectorAddress);
                    } else {
                        log("Cannot find the agent jar for JVM [%s] at [%s]", vmd.id(), javaHome);
                    }
                }
                // Now lets try and connect and read some MBean values
                if(connectorAddress!=null) {
                    log("Attaching to JVM [%s]...", vmd.id());
                    JMXServiceURL jmxUrl = new JMXServiceURL(connectorAddress);
                    JMXConnector connector = null;
                    try {
                        connector = JMXConnectorFactory.connect(jmxUrl);
                        MBeanServerConnection conn = connector.getMBeanServerConnection();
                        MemoryUsage heap = MemoryUsage.from((CompositeData)conn.getAttribute(new ObjectName(ManagementFactory.MEMORY_MXBEAN_NAME), "HeapMemoryUsage"));
                        log("Heap Usage: %s", heap);
                    } finally {
                        if(connector!=null) {
                            try { connector.close(); } catch (Exception ex) {/* No Op */}
                        }
                    }
                }
            } catch (Exception ex) {
                /* No Op */
            } finally {
                if(vm!=null) try { vm.detach(); } catch (Exception ex) {/* No Op */}
                             log("======================================");
            }
        }

    }

    public static void log(String fmt, Object...args) {
        System.out.println(String.format(fmt, args));
    }

}