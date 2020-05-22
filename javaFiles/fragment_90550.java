class AnimalType {
    private static final Map<String, Animal> animals  = new HashMap<String, Animal>();

    static {
        // Populating map with default animals
        addAnimal("big","BELLOWWWWW"); // bison
        addAnimal("small","SQUEEEEEAK"); // mouse
        addAnimal("lazy","ROARRRRR"); // lion
        addAnimal("loyal","WOOF "); // dog
    }

    public static void addAnimal(String criteria, final String sound) {
        // Assigning a anonymous implementation of animal to the given criteria
        animals.put(criteria, new Animal() {
            @Override
            public void talk() {
                System.out.println(sound);
            }
        });
    }

    public static Animal getAnimal(String criteria) {
        // Returning an animal from the animals map
        return animals.get(criteria);
    }
}