public class Worker extends SwingWorker<Integer, Integer> {
    private GeneralUserInterface gui;

    // omitted...

    @Override
    protected Integer doInBackground() throws Exception {
        int someResultToReturn = 10;

        for(int i=0; i<100; i++){
            Thread.sleep(50);//The Work
            publish(i+1);//calls process, which updates GUI
        }

        return someResultToReturn;
    }

    // omitted...

    @Override
    protected void done() {

        try {
           int resultToGet = worker.get();//Obviously freezes the GUI
        } catch (InterruptedException | ExecutionException ex) {}

       //NEXT LINE NEEDS THE RESULT TO CONTINUE
   }
}

private void jButtonDoWorkActionPerformed(java.awt.event.ActionEvent evt) {
    Worker worker = new Worker(this);
    worker.execute();
}