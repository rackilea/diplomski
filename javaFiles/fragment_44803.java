UIJob job = new UIJob("Job title") {
        @Override
        public IStatus runInUIThread(IProgressMonitor monitor) {

            updateView();

            return Status.OK_STATUS;
        }
    };

job.schedule(3000);