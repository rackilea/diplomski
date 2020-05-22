List<DBAnimalDTO> dbAnimals = animals.stream().map(animal -> {
    if (animal instanceof Dog) {
        return dogFunction.apply((Dog) animal);
    } else {
        return catFunction.apply((Cat) animal);
    }
}).collect(Collectors.toList());