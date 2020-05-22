Iterator<MemoryPoolMXBean> iter = ManagementFactory.getMemoryPoolMXBeans().iterator();
while (iter.hasNext())
{
    MemoryPoolMXBean item = iter.next();
    String name = item.getName();
    MemoryType type = item.getType();
    MemoryUsage usage = item.getUsage();
    MemoryUsage peak = item.getPeakUsage();
    MemoryUsage collections = item.getCollectionUsage();
}