class Fruit {
    void taste() {
        System.out.println("delicious!");
    }
}

class Apple extends Fruit{
    void taste() {
        System.out.println("sweet!");
    }
}

class Orange extends Fruit{
    void taste() {
        System.out.println("juicy!");
    }
}

class Polymorph {
    public static void main(String... args) {
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        Fruit fruit_apple = new Apple();
        Fruit fruit_orange = new Orange();

        fruit.taste(); // prints delicious!
        apple.taste(); // prints sweet!
        fruit_apple.taste(); // prints sweet!
        fruit_orange.taste(); // prints juicy!
    }
}