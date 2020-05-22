boolean addAnimal(int type, String name, int age) {
    if (type == 1) {
        animals.add(new Dog(name, age));
    }
    else if (type == 2) {
        animals.add(new Cat(name, age));
    }
    else {
        animals.add(new Bird(name, age));
    }
    return true; // You can probably make this a void method now
}