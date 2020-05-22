public Iterable<Animal> animals(){
    return Collections.unmodifiableList( animalList );
}

for(Animal a : zoo.animals()) {
    //do something
}