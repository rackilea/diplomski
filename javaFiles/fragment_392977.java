public static <T> void myMethod(T obj) { // <-- generic type T
  if (obj instanceof String) {
    System.out.println("Printing String directly: " + (String) obj);
  } else {
    System.out.println("Printin String by toString(): " + obj.toString());
  }
}

public static void main(String[] args) {
  myMethod("Hello");
  myMethod(new Date());
}