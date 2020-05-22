import java.util.*;

abstract class Fruit {
    public abstract String getColor();
}

class Banana extends Fruit {
    @Override public String getColor() {
        return "yellow";
    }
}

class Apple extends Fruit {
    @Override public String getColor() {
        return "green";
    }
}

public class Test {

    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<Fruit>();
        list.add(new Banana());
        list.add(new Apple());

        for (Fruit fruit : list) {
            System.out.println(fruit.getColor());
        }
    }
}