public abstract class Parent {

    public void run() {

        InputStream in = null;    
        try {
            in = new URL("bladiebla").openConnection().getInputStream();    
            String text = // ...read text from InputStream     
            if (text == null || text.length() == 0) {
                handleMyEvent(new NoInputEvent());
                return;
            }           
            doWork(text);
        } catch (MalformedURLException e) {
            handleMyEvent(new MyEvent(e));                
        } catch (IOException e) {
            handleMyEvent(new MyEvent(e));
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                }
                catch(IOException e) {
                    handleMyEvent(e);
                }
            }
        }
    }            

    abstract void doWork(String text);

    abstract void handleMyEvent(MyEvent myEvent);
}

public class MyEvent {
    private Exception exception;
    public MyEvent() {}
    public MyEvent(Exception exception) {//set it}
}

public class NoInputEvent extends MyEvent {        
}