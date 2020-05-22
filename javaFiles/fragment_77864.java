public class MyExceptionHandler {
    public void handle(Throwable ex) {
        // Handle exception
    }
    public void handle(Thread t, Throwable ex) {
        // Handle exception
    }
}

System.setProperty("sun.awt.exception.handler", MyExceptionHandler.class.getName());