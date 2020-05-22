ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getDefault().getActiveShell());
        try {
            dialog.run(true, true, new IRunnableWithProgress() {

                @Override
                public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    monitor.beginTask("Tracing", 100);
                    while(!monitor.isCanceled()) {
                        Display.getDefault().readAndDispatch();
                        // Do your work here
                    }
                }
            });
        } catch (InvocationTargetException | InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }