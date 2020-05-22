public class AnimalFactory {

  public static Animal createAnimal() throws Exception {
    final String animalClassName = getThisValueFromApplicationProperties();
    return Class.forName(animalClassName).getConstructor().newInstance();
  }
}