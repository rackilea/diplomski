// you never gave us the employee class, so I had to create one of my own
class Employee2 {
    private String name;
    private int value;
    private boolean bool;

    public Employee2(String name, int value, boolean bool) {
        this.name = name;
        this.value = value;
        this.bool = bool;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean isBool() {
        return bool;
    }
}