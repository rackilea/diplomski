public static void main(String[] args) {
    Person p = new Person();
    // We are creating a random Fruit, and pass it to the person to eat.
    // We can´t be more specific here and don´t need to be more specific
    Fruit f = getRandomFruit();
    p.eat(f);
}

public static Fruit getRandomFruit() {
    if(new Random().nextInt(2) == 0) {
        return new Banana();
    } else {
        return new Apple();
    }
}