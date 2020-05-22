MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

Hello h1 = new Hello();
Hello h2 = new Hello();
CompositeHello composite = new CompositeHello(h1, h2);
mbs.registerMBean(composite, new ObjectName("mBeans:type=Hello"));