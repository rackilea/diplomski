public class Progress {
    public static void main(String[] args)
    {
        // Create your new ProgressMonitorDialog with a IRunnableWithProgress
        try {
            // 10 is the workload, so in your case the number of files to copy
            IRunnableWithProgress op = new YourThread(10);
            new ProgressMonitorDialog(new Shell()).run(true, true, op);
         } catch (InvocationTargetException ex) {
             ex.printStackTrace();
         } catch (InterruptedException ex) {
             ex.printStackTrace();
         }
    }

    private static class YourThread implements IRunnableWithProgress
    {
        private int workload;

        public YourThread(int workload)
        {
            this.workload = workload;
        }

        @Override
        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException
        {
            // Tell the user what you are doing
            monitor.beginTask("Copying files", workload);

            // Do your work
            for(int i = 0; i < workload; i++)
            {
                // Optionally add subtasks
                monitor.subTask("Copying file " + (i+1) + " of "+ workload + "...");

                Thread.sleep(2000);

                // Tell the monitor that you successfully finished one item of "workload"-many
                monitor.worked(1);

                // Check if the user pressed "cancel"
                if(monitor.isCanceled())
                {
                    monitor.done();
                    return;
                }
            }

            // You are done
            monitor.done();
        }

    }
}