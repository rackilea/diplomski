Animal[] animals = new Animal[20];
animals[0] = new Dog();
animals[1] = new Cat();

for (Animal a : animals) {
    a.speak();  // you don't know what Animal it is, but the proper speak method will be called.
}