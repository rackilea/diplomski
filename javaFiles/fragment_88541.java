public void ouch() {
    List<Dog> dogs = Arrays.asList(new Dog(), new Dog());
    List<Animal> animals;
    // This would be legal, right? Because a list of dogs is a list of animals.
    List<Animal> animals = dogs;
    // This would be legal, right? Because a cat could be added to a
    // list of animals, because a cat is an animal.
    animals.add(new Cat());
    // Unfortunately, we have a confused cat.
}