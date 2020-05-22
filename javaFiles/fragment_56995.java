class YourWorker extends SwingWorker<Foo, Bar> {

    // ...

    protected Foo doInBackground() throws Exception {
        while (someCondition) {
            publish(doSomeIntermediateWork());
            if (isCancelled())
                return null; // we're cancelled, abort work
        }
        return calculateFinalResult();
    }

}

// To abort the task:
YourWorker worker = new YourWorker(args);
worker.execute();
doSomeOtherStuff();
if (weWantToCancel)
    worker.cancel(false); // or true, doesn't matter to us here