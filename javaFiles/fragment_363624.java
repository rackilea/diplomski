int numAnimals = infile.nextInt();
infile.nextLine();
kennel.setName(kennelName);
for (int i = 0; i < numAnimals; i++) {
  if(infile.nextLine().equals("cat")) {
    Cat cat = readCat(infile);
    kennel.addAnimals(cat);
}
  else if(infile.nextLine().equals("dog")){
    Dog dog = readDog(infile);
    kennel.addAnimals(dog);
}
}

public Dog readDog(Scanner infile) {
  //same as your dog reading part except the last part
  return new Dog(animalName, owners, likesBones, favFood,
      feedsPerDay);
}