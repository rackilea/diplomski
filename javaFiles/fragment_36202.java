class Animal {
    protected String name = "Animal";

    public String getName() {
        return name;
    }
}

class Cat extends Animal {
    public Cat() {
        this.name = "Cat";
    }
}