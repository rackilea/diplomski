/**
     * Registers the JVM metrics to the metric registry and start to report
     * the registry metrics via JMX.
     */
    public void registerMetrics() {
        if (metricsAreRegistered) {
            return;
        }
        getMetricRegistry().register("jvm.attribute", new JvmAttributeGaugeSet());
        getMetricRegistry().register("jvm.buffers", new BufferPoolMetricSet(ManagementFactory
                                                                               .getPlatformMBeanServer()));
        getMetricRegistry().register("jvm.classloader", new ClassLoadingGaugeSet());
        getMetricRegistry().register("jvm.filedescriptor", new FileDescriptorRatioGauge());
        getMetricRegistry().register("jvm.gc", new GarbageCollectorMetricSet());
        getMetricRegistry().register("jvm.memory", new MemoryUsageGaugeSet());
        getMetricRegistry().register("jvm.threads", new ThreadStatesGaugeSet());

        JmxReporter.forRegistry(metricRegistry).build().start();
        metricsAreRegistered = true;
    }