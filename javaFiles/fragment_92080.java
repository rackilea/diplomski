public class Creator {

private String name;

public Creator(String name) {
    this.name = name;
}

public String getName() {
    return name;
}

public int hashCode() {
    return name.hashCode();
}

public boolean equals(Object other) {
   if (!(other instanceof Creator)) {
      return false;
   }
   return Objects.equals(((Creater)other).name, name);
}