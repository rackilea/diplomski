public class SomeClass {

    private final ReadOnlyStringWrapper message = new ReadOnlyStringWrapper(this, "message");

    private void setMessage(String message) {
         this.message.set(message); 
    }

    public final String getMessage() { 
        return message.get(); 
    }

    public final ReadOnlyStringProperty messageProperty() {
        return message.getReadOnlyProperty();
    }

}