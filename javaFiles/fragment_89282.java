class DemoJobCreator implements JobCreator {

        @Override
        public Job create(String tag) {
            switch (tag) {
                case TrackingJob.TAG:
                    return new TrackingJob ();
                default:
                    return null;
            }
        }
    }