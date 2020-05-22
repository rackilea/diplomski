class Dog extends Animal implements Sayable {
    @Override
    public void say() {
        System.out.println("bau bau");
    }
}

class Cat extends Animal implements Sayable {
    @Override
    public void say() {
        System.out.println("miao");
    }
}

class Rabbit extends Animal {
    // a rabbit unfortunately does not speak,
    // so don't make it implement Sayable
}