public void addFriend(Person person) {
    if (friends.get(person.name) == null) friends.put(person.name, person);
    person.friends.put(name, this);
}

public void removeFriend(Person person) {
    if (friends.get(person.name) != null) friends.remove(person.name);
    person.friends.remove(name);
}

// Only add this to test and see the list of friends.
public void printFriends() {
    System.out.println(name + "'s Friends:");
    for (Person p : friends.values()) {
        System.out.println("    " + p.name);
    }
}