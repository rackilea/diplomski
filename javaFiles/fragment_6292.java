public class Person {
    String name;

    public Person(String name) {this.name = name;}

    Set<Person> friends = new HashSet<Person>();

    public void addFriend(Person person) {
        friends.add(person);
        person.friends.add(this);
    }

    public void removeFriend(Person person) {
        friends.remove(person);
        person.friends.remove(this);
    }

    public void printFriends() {
        System.out.println(name + "'s Friends:");
        for (Person p : friends) {
            System.out.println("    " + p.name);
        }
    }
}