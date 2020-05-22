class RequestPerformanceMetadata implements PerformanceMetadataMBean {
    private double startTime;
    private double endTime;
    private double timeTook;
    private String requestType;
    private int numOfRequests;
    private MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    private ObjectName name;

    public RequestPerformanceMetadata() {
        try {
            name = new ObjectName("test.performace:type=PerformanceMetadataMBean"); 
            mbs.registerMBean(this, name);     
        } catch (Exception ex) {
            throw new RuntimeException("Yo dog. Bad object name", ex);
        }       
    }    
   //........... snip ...........
}