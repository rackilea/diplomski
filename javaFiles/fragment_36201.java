class Animal {
    private String name="Animal";

    public String getName() {
        return this.name;
    }
}

class Cat extends Animal {
    public String getName() {
        return "Cat";
    }
}