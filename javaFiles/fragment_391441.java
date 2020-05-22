boolean supportsProfiling(Application application) {
        // Application already being profiled (Startup Profiler)
        if (application == getProfiledApplication()) return true;

        // Remote profiling is not supported
        if (application.getHost() != Host.LOCALHOST) return false;

        ...