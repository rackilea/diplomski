public class AnyObject {

private String name;
private int num;
private String color;

public AnyObject(String name, int num, String color) {
    this.name = name;
    this.num = num;
    this.color = color;
}

@Override
public String toString() {
    return name;
}