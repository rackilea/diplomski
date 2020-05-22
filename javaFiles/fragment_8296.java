abstract class Message {
    public abstract void doSomething();
    private String myType; // or enum, or whatever

    public String getMyType() {
        return myType;
    }

    public static Message parse(String s) {
        // parse s
        // if s contains command 'register', return a new RegisterMessage
        // if s contains command 'someDataGet', return a new SomeDataGetMessage

        return // a newly created message;
        }
    }

    class MessageRegister extends Message {

    @Override
    public void doSomething() {
        // do what a Register message does          
    }

    public MessageRegister() {
        myType = "REGISTER";
    }

}

class MessageSomeDataGet extends Message {

    @Override
    public void doSomething() {
        // do what a SomeDataGet message does       
    }

    public MessageSomeDataGet() {
        myType = "SOMEDATAGET";
    }
}