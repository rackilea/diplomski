MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

Hello h1 = new Hello();
Hello h2 = new Hello();

mbs.registerMBean(h1, new ObjectName("mBeans:type=Hello-1"));
mbs.registerMBean(h2, new ObjectName("mBeans:type=Hello-2"));