class SequentialInvoker extends SwingWorker<Void, Integer> {
    @Override
    public void doInBackground() {

        changeTabPanel();
        copySomeFiles();
        enableNextButton1();
        setProgress(10);

        readInFiles();
        doSomethingToFiles();
        setProgress(15);

        doSomethingElse();
        setProgress(100);
    }
}