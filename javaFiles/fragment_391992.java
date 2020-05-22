class Dog {
    public void bark() {System.out.println("woof");}
}

class Cat {
    public void meow() {System.out.println("meow");}
}

class Demo {
    public static void main(String[] args) {
        ArrayList<Object> animals = new ArrayList<Object>();
        animals.add(new Cat());
        animals.add(new Dog());
        for (Object animal: animals) {
            if (animal instanceof Dog) {
                ((Dog)animal).bark();
            } else if (animal instanceof Cat) {
                ((Cat)animal).meow();
            }
        }
    }
}