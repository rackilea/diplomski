public interface Attribute {
    String getName();
}

public enum Subsystem implements Attribute {
    PROCESSOR ("Processor"), 
    MONITOR ("Monitor"), 
    MOUSE ("Mouse"), 
    KEYBOARD ("Keyboard");

    private final String value;

    private Subsystem(String value){
        this.value = value;
    }

    @Override
    public String getName() {
        return value;
    }
}

public enum Action implements Attribute {
    EXECUTE ("Execute"), 
    DISPLAY ("Display"), 
    CLICK ("Click"), 
    ACCEPT ("Accept");

    private final String value;

    private Action(String value){
        this.value = value;
    }

    @Override
    public String getName() {
        return value;
    }
}