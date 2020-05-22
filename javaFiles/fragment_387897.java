public class MainProject{
  private static final DogBreeds breeds = C10N.get(DogBreeds.class);

  public void createDogs(){
    //Create a poodle
    Dog poodle = new Dog(new BreedNameProvider(){
      @Override
      public String getBreedName(){
        return breeds.poodle();
      }
    });

    //Create dalmatian
    Dog dalmatian = new Dog(new BreedNameProvider(){
      @Override
      public String getBreedName(){
        return breeds.dalmatian();
      }
    });
  }
}