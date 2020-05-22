public class MYUI extends Application implements EventHandler<WindowEvent> {  
    @Override  
    public void start(Stage s) throws Exception {  
      s.setOnCloseRequest(this);  
    }  

    @Override  
    public void stop() throws Exception {  
    }  

    @Override  
    public void handle(WindowEvent event) {  
        [...] your code
    }  
}