class Animal {

    String whatAmI = "An Animal";

    public void sayHi() {
        System.out.println("Hi from Animal");
    }
}

class Dog extends Animal {

    String whatAmI = "A Dog";

    public void sayHi() {
        System.out.println("Hi from Dog");
    }
}