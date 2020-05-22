Dog dog = new Dog();
Cat cat = new Cat();
Rabbit rabbit = new Rabbit();

ArrayList<Animal> list = new ArrayList<Animal>();
list.add(dog);
list.add(cat);
list.add(rabbit);

for (Animal obj : list) {
    if (obj instanceof Sayable) {
        Sayable sayable = (Sayable) obj;
        sayable.say();
    }
}