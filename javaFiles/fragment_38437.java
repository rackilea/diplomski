class Person {
    private String firstName;
    private String lastName;
    private int age;
    //accessor methods
}

Class clazz = Class.forName("com.jigar.stackoverflow.test.Person");
for (Field f : clazz.getDeclaredFields()) {
      System.out.println(f.getName());
}