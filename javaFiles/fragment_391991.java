abstract class Animal {
    public abstract void makeNoise();
}

class Cat extends Animal {
    public void makeNoise() { System.out.println("meow");}
}

class Dog extends Animal {
    public void makeNoise() { System.out.println("woof");}
}

class Demo {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Cat());
        animals.add(new Dog());
        for (Animal animal: animals) {
            animal.makeNoise();
        }
    }
}