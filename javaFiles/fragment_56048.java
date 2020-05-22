public class MyClass {

    private String name;

    private int age;

    private String color;

    private final List<String> colors = Arrays.asList("Black", "White", "Brown ", "Grey");

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      if (colors.contains(color)) {
        this.color = color;
      } else {
        // if not valid do what you want
      }
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      if (age > 0 && age <= 100) {
        this.age = age;
      } else {
        // if not valid do what you want
      }
    }

  }