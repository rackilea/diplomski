/**
     * Returns a large bunch of memory information.
     */
    public static String getAllMemoryInformation() {
        StringBuilder b = new StringBuilder();
        b.append("Current PID: "+getPid()+"\n"); //$NON-NLS-1$

        com.sun.management.OperatingSystemMXBean osb =
            (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
        b.append("Physical memory: "+formatMemory(osb.getTotalPhysicalMemorySize())+" total, "+ //$NON-NLS-1$ //$NON-NLS-2$
                formatMemory(osb.getFreePhysicalMemorySize())+" free.\n"); //$NON-NLS-1$
        b.append("Swap space: "+formatMemory(osb.getTotalSwapSpaceSize())+" total, "+ //$NON-NLS-1$ //$NON-NLS-2$
                formatMemory(osb.getFreeSwapSpaceSize())+" free.\n"); //$NON-NLS-1$

        MemoryUsage m = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        b.append("Heap memory usage: "+formatMemory(m.getInit())+" initial, "+ //$NON-NLS-1$ //$NON-NLS-2$
                                                 formatMemory(m.getUsed())+" used, "+ //$NON-NLS-1$
                                                 formatMemory(m.getCommitted())+" committed, "+ //$NON-NLS-1$
                                                 formatMemory(m.getMax())+" max.\n"); //$NON-NLS-1$
        for( MemoryPoolMXBean mpb : ManagementFactory.getMemoryPoolMXBeans() ) {
            if( mpb.getType().equals(MemoryType.HEAP) ) {
                 m = mpb.getUsage();
                b.append("- " + mpb.getName()+" usage: "+formatMemory(m.getInit())+" initial, "+  //$NON-NLS-2$ //$NON-NLS-3$
                        formatMemory(m.getUsed())+" used, "+ //$NON-NLS-1$
                        formatMemory(m.getCommitted())+" committed, "+ //$NON-NLS-1$
                        formatMemory(m.getMax())+" max.\n"); //$NON-NLS-1$
            }
        }

        m = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        b.append("Non-Heap memory usage: "+formatMemory(m.getInit())+" initial, "+ //$NON-NLS-1$ //$NON-NLS-2$
                                                     formatMemory(m.getUsed())+" used, "+ //$NON-NLS-1$
                                                     formatMemory(m.getCommitted())+" committed, "+ //$NON-NLS-1$
                                                     formatMemory(m.getMax())+" max.\n"); //$NON-NLS-1$
        for( MemoryPoolMXBean mpb : ManagementFactory.getMemoryPoolMXBeans() ) {
            if( mpb.getType().equals(MemoryType.NON_HEAP) ) {
                 m = mpb.getUsage();
                b.append("- " + mpb.getName() + " usage: "+formatMemory(m.getInit())+" initial, "+  //$NON-NLS-2$ //$NON-NLS-3$
                        formatMemory(m.getUsed())+" used, "+ //$NON-NLS-1$
                        formatMemory(m.getCommitted())+" committed, "+ //$NON-NLS-1$
                        formatMemory(m.getMax())+" max.\n"); //$NON-NLS-1$
            }
        }
        return b.toString();
    }