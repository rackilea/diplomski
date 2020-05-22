Dog dog = new Dog();
Breed breed = dao.getBreedById(1); (gets persistent object)

dog.setName("Pluto");
dog.setBreed(breed);
breed.getDogCollection.add(dog);//you have to maintain relationship manually

save(dog);