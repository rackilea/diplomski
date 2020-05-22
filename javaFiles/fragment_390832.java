public class ConcreteCommand implements Command {

    private Object something;

    public ConcreteCommand(Object something) {
        this.something = something;
    }

    @Override
    public void execute() {
        // ...
    }

}