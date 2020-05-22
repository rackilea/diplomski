public List<String> getAllDogNames(String prefix){
  List<Dog> dogs = this.getAllDogs();
  List<String> names = new ArrayList<String>();
  for (dog : dogs) {
    names.add(prefix + dog.getName()); //Or whatever
  }
}