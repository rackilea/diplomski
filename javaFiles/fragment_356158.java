class Foo {
private String name;
private int value1;
private int value2;

public String getName() { return name; }
public int getValue1() { return value1; }
public int getValue2() { return value2; }

public void setName(String name) { this.name = name; }
public void setValue1(int value1) { this.value1 = value1; }
public void setValue2(int value2) { this.value2 = value2; }

public String toString() {
    return String.format("name: %s, value1: %d, value2: %d", name, value1, value2);
}
}