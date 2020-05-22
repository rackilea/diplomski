public class MainProject{
  private static final DogBreeds breeds = C10N.get(DogBreeds.class);

  class CodeBreedNameProvider implements BreedNameProvider{
    private final String breedCode;

    CodeBreedNameProvider(String breedCode){
      this.breedCode = breedCode;
    }

    @Override
    public String getBreedName(){
      switch(breedCode){
        case "poodle": return breeds.poodle();
        case "dalmatian": return breeds.dalmatian();
        //... more if needed
      }
      return "unknown breed code " + breedCode;
    }
  }

  public void createDogs(){
    //Create a poodle
    Dog poodle = new Dog(new CodeBreedNameProvider("poodle"));

    //Create dalmatian
    Dog dalmatian = new Dog(new CodeBreedNameProvider("dalmatian"));
  }
}