public class DatabaseWriter {
    public void save(Object msg) {
        if (msg.getClass().isAnnotationPresent(Message.class)) { 
           //some code
        }
    }
}