String animals = input("Name an animal");

    int numberAnimals;
    int maxNumAnimals = Integer.MIN_VALUE; // initialize as the smallest int value

    String leastEndangeredAnimal = "";
    while (!animals.equalsIgnoreCase("Exterminate")) {
            remaining = input("How many are left in the wild?");
            numberAnimals = Integer.parseInt(remaining);
            if (maxNumAnimals < numberAnimals) {
                maxNumAnimals = numberAnimals;
                leastEndangeredAnimal = animals;
            }
        animals = input("Name an animal");
    }

    print("The least endangered animal is " + leastEndangeredAnimal);

    print("There are still " + maxNumAnimals + " left in the wild");