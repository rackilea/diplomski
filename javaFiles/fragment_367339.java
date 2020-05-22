ObjectName name = new ObjectName("Catalina:j2eeType=WebModule,name=//localhost/" + contextPath + ",J2EEApplication=none,J2EEServer=none");
MBeanServer mx = ManagementFactory.getPlatformMBeanServer();

String state = String.valueOf(mx.getAttribute(name, "stateName"));
if (state.equals("STARTED")) {
    LOGGER.warn("SUCCESS!");
}