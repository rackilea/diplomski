public static void myMethod(Object obj) { // Any Object
  if (obj instanceof String) {
    System.out.println("Printing String directly: " + (String) obj);
  } else {
    System.out.println("Printin String by toString(): " + obj.toString());
  }
}