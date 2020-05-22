public interface Fruit {
    public static void printOptional(Optional<Fruit> optionalFruit) {
        if (optionalFruit.isPresent()) {
            String color = optionalFruit.get().getColor();
            System.out.println("The fruit is " + color + ".");
        } else {
            System.out.println("unknown fruit");
        }
    }

    String getColor();
}

public class Apple implements Fruit {
    @Override
    public String getColor() {
        return "red";
    }
}

public class Banana implements Fruit {
    @Override
    public String getColor() {
        return "yellow";
    }
}