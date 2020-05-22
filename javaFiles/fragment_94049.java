public class Person {

    String name;
    String surname;
    int age;

    List<String> friends;

    public Person(String name, String surname, int age, List<String> friends) {
      this.name = name;
      this.surname = surname;
      this.age = age;
      this.friends = friends;
    }    
}

List<String> friends = new Arraylist<String>();
friends.add("Chicken");
friends.add("Weedwacker");
friends.add("CornCob");
Person person = new Person("Name", "Surname", 42, friends);