abstract class Animal {
  private static final Map<String, Animal> map
      = new HashMap<String,Object>();

  static {
    map.put("Cow", new Cow());
  }

  static Animal getAnimal(String name) {
    // TODO: Validation
    return map.get(name);
  }

  abstract int age();
}