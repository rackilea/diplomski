static final Function<Animal, Void> eatFunction = new Function<Animal, Void>() {
    @Override
    public Void apply(Animal animal) {
        animal.eat();
        return null; // ugly as hell, but necessary to compile
    }
}

Lists.newArrayList(Collections2.transform(animalList, eatFunction));