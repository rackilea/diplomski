List memBeans = ManagementFactory.getMemoryPoolMXBeans();           
for (Iterator i = memBeans.iterator(); i.hasNext(); ) {

    MemoryPoolMXBean mpool = (MemoryPoolMXBean)i.next();
    MemoryUsage usage = mpool.getUsage();

    String name = mpool.getName();      
    float init = usage.getInit()/1000;
    float used = usage.getUsed()/1000;
    float committed = usage.getCommitted()/1000;
    float max = usage.getMax()/1000;
    float pctUsed = (used / max)*100;
    float pctCommitted = (committed / max)*100;

}