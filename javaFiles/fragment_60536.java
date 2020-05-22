MBeanServerConnection mbs = ManagementFactory.getPlatformMBeanServer();
Set<ObjectName> gcnames = mbs.queryNames(new ObjectName(ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",name=*"), null);
Set<GarbageCollectorMXBean> gcBeans = new HashSet<GarbageCollectorMXBean>(gcnames.size());
for(ObjectName on: gcnames) {
    gcBeans.add(ManagementFactory.newPlatformMXBeanProxy(mbs, on.toString(), GarbageCollectorMXBean.class));
}