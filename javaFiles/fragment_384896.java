public class LoggingThing implements MyBehaviour {
    public MyBehaviour delegate;

    public LoggingThing(MyBehaviour delegate) {
        this.delegate = delegate;
    }

    @Override
    public void eat() {
        try {
            delegate.eat();
        } catch (MyException e) {
            // extra behaviour
        }
    }
}