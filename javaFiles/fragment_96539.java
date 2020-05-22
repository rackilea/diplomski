class Fruit {

// Return int number of pieces of peel that
// resulted from the peeling activity.
public int peel() {

    System.out.println("Peeling is appealing.");
    return 1;
}
 }

class Apple {

private Fruit fruit = new Fruit();

public int peel() {
    return fruit.peel();
}
}

class Example2 {

public static void main(String[] args) {

    Apple apple = new Apple();
    int pieces = apple.peel();
}
}