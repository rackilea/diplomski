@Anno
public class Q48177784 {
  public static final List<Class<?>> CLASSES;
  static {
    try {
      URL resource = Q48177784.class.getClassLoader().getResource("TestInfo");
      CLASSES = Files.readAllLines(Paths.get(resource.toURI()))
          .stream()
          .map(s -> {
            try {
              return Class.forName(s);
            } catch (ClassNotFoundException e) {
              throw new Error(e);
            }
          })
          .collect(Collectors.toList());
    } catch (Exception e) {
      throw new Error(e);
    }
  }

  public static void main(String[] args) {
    System.out.println(CLASSES);
  }
}