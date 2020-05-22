@Autowired
MBeanExporter exporter;

private static final Logger LOG = LogManager.getLogger();
private final HashMap<String, Object> jmxBeans = new HashMap();

JmxData getStatisticsBean(ProceedingJoinPoint joinPoint) {
    String id = "bean:name=" + joinPoint.getTarget().getClass().toString() + "." + joinPoint.getSignature().getName();
    if (!jmxBeans.containsKey(id)) {
        synchronized (jmxBeans) {
            if (!jmxBeans.containsKey(id)) {
                JmxData jmxStatistics = new JmxData(id);
                jmxBeans.put(id, jmxStatistics);
                try {
                    exporter.registerManagedResource(jmxStatistics, new ObjectName(id));
                } catch (MalformedObjectNameException ex) {
                    LOG.warn("Error while registering " + id, ex);
                }
            }
        }
    }
    return (JmxData) jmxBeans.get(id);
}