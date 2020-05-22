try {
    // Open the image file
    InputStream is = new BufferedInputStream(
        new FileInputStream("filename.gif"));
    // Create the print job
    DocPrintJob job = service.createPrintJob();
    Doc doc = new SimpleDoc(is, flavor, null);

    // Monitor print job events
    PrintJobWatcher pjDone = new PrintJobWatcher(job);

    // Print it
    job.print(doc, null);

    // Wait for the print job to be done
    pjDone.waitForDone();

    // It is now safe to close the input stream
    is.close();
} catch (PrintException e) {
} catch (IOException e) {
}

class PrintJobWatcher {
    // true iff it is safe to close the print job's input stream
    boolean done = false;

    PrintJobWatcher(DocPrintJob job) {
        // Add a listener to the print job
        job.addPrintJobListener(new PrintJobAdapter() {
            public void printJobCanceled(PrintJobEvent pje) {
                allDone();
            }
            public void printJobCompleted(PrintJobEvent pje) {
                allDone();
            }
            public void printJobFailed(PrintJobEvent pje) {
                allDone();
            }
            public void printJobNoMoreEvents(PrintJobEvent pje) {
                allDone();
            }
            void allDone() {
                synchronized (PrintJobWatcher.this) {
                    done = true;
                    PrintJobWatcher.this.notify();
                }
            }
        });
    }
    public synchronized void waitForDone() {
        try {
            while (!done) {
                wait();
            }
        } catch (InterruptedException e) {
        }
    }
}