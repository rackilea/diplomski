public class Worker extends SwingWorker<Void, String> {



    @Override
    protected Void doInBackground() throws Exception {
       //here you make heavy task this is running in another thread not in EDT
       setProgress(0);
       setChanged();
       publish("Start reading log...");   
       setProgress(43);
       //another operation
       publish("Start reading log...");    
       setProgress(89);
       .
       .
       return null; // you have to add this, Void is wrapper class of native void
    }
    @Override
    protected void process(List<String> chunks){
      // here is called when you call publish in doInBackground, this is executed in EDT 
        if(chunks == null || chunks.isEmpty())
                return;
        firePropertyChange("message",null,chunks.get(0));
    }

}