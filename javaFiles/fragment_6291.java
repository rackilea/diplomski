public class Person {
    String uuid = UUID.randomUUID().toString();

    HashMap<String, Person> friends = new HashMap<String, Person>();

    public void addFriend(Person person) {
        if (friends.get(person.uuid) == null) friends.put(person.uuid, person);
        person.friends.put(uuid, this);
    }

    public void removeFriend(Person person) {
        if (friends.get(person.uuid) != null) friends.remove(person.uuid);
        person.friends.remove(uuid);
    }

    public void printFriends() {
        System.out.println(uuid + "'s Friends:");
        for (Person p : friends.values()) {
            System.out.println("    " + p.uuid);
        }
    }
}