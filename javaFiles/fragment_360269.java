static final String HOTSPOT_BEAN_NAME = "com.sun.management:type=HotSpotDiagnostic";

public static void main(String[] args) throws Exception {
    Class clazz = Class.forName("com.sun.management.HotSpotDiagnosticMXBean");
    MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    HotSpotDiagnosticMXBean bean = (HotSpotDiagnosticMXBean) ManagementFactory
            .newPlatformMXBeanProxy(server, HOTSPOT_BEAN_NAME, clazz);
    VMOption vmOption = bean.getVMOption("CompileThreshold");
    System.out.printf("%s = %s%n", vmOption.getName(), vmOption.getValue());
}