public static void main(String[] args) {
    Stream<Animal> animals = Arrays.asList(new Animal("A"),new Animal("B")).stream();
    AnimalFactory animalFactory = new AnimalFactory();
    animalFactory.withFactory("A", Bird::new);
    animalFactory.withFactory("B", Lion::new);
    animalFactory.withFactory("C", Tiger::new);
    animalFactory.withFactory("D", Fish::new);

    Stream result = animals.map(animalFactory::createAnimal);
}