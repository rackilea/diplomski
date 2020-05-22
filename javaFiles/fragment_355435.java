/**
     * Custom StdSchedulerFactory
     *
     * Sets signalOnSchedulingChange to false so the SchedulerThread does not wake on every scheduleJob
     */
    public class CustomStdSchedulerFactory extends StdSchedulerFactory {

        private static final Logger LOG = LoggerFactory.getLogger(CustomStdSchedulerFactory.class);

        @Override
        protected Scheduler instantiate(QuartzSchedulerResources rsrcs, QuartzScheduler qs) {

            LOG.info("setting signalOnSchedulingChange to false");
            qs.setSignalOnSchedulingChange(false);

            return super.instantiate(rsrcs, qs);
        }
    }