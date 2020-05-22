public class Foo {

  private static final Map<String, Mammal> NAME_TO_MAMMAL_MAP;

  static {
    NAME_TO_MAMMAL_MAP = new HashMap<String, Mammal>();
    for (Human human : EnumSet.allOf(Human.class)) {
      NAME_TO_MAMMAL_MAP.put(human.name(), human);
    }
    for (Animal animal : EnumSet.allOf(Animal.class)) {
      NAME_TO_MAMMAL_MAP.put(animal.name(), animal);
    }
  }

  public static Mammal bar(final String arg) {
    return NAME_TO_MAMMAL_MAP.get(arg);
  }
}