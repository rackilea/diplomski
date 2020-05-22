public abstract class TopHandler {

    //Other methods... 

    public void sendMessage() {
        TopHandler handler = createHandler();
        //Call Handler implementation of abstract methods
    }

    public abstract TopHandler createHandler();
}