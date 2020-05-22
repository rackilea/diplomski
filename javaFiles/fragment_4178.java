public class TestTask extends AsyncTask{

    private boolean notified;
    private Promptable p;
    public interface Promptable { public abstract void prompt(); }

    public TestTask(Promptable p){
        this.p = p;
    }

    @Override
    protected Object doInBackground(Object... arg0) {
        Log.d("First", "First");
        onProgressUpdate(null);
        synchronized(this){
            while(!notified){
                try{
                    this.wait();
                }
                catch(InterruptedException e){ }                    
            }
        }
        Log.d("Second", "Second");
        return null;
    }

    @Override 
    protected void onProgressUpdate(Object... args){       
        synchronized(this){
            notified = true;
            p.prompt();               
            this.notify();
        }
    }
}