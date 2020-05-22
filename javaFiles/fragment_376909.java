static final Block<Animal> eatFunction = new Block<Animal>() {
    @Override
    public void apply(Animal animal) {
        animal.eat();
    }
};