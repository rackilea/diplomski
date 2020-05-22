List<Animal> animalGroup = Demo.animalGroup; 

animalGroup.forEach(animal -> System.out.println(animal.getName() + "," + animal.getAge()));

System.out.println("************ArrayList after sorting************");

Collections.sort(animalGroup, new AgeComparator()); // Sort highest to lowest

animalGroup.forEach(animal -> System.out.println(animal.getName() + "," + animal.getAge()));