public void doSoemthing(Mammal mammal) {
    if (mammal instanceof Human) {
        Human human = (Human) mammal;
        human.doWork();
    } else if (mammal instanceof Dog) {
        Dog dog = (Dog) mammal;
        dog.bark();
    }
}