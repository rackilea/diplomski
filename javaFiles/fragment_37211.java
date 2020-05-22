//in Position.java
public enum Position {
    DESIGN("Design"),
    MANUFACTURING("Manufacturing"),
    SALES("Sales");

    private final String positionName;

    //note enums have private constructors
    private Position(String positionName) {
        this.positionName= positionName;
    }

    //you're overriding the default toString() method
    //defined for all objects in Java, so add @Override
    @Override
    public String toString() {
        return positionName;
    }
}