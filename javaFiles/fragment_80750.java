class Person {
    private Set<Person> friends = new HashSet<>();

    public void addFriend(Person newFriend) {
        friends.add(newFriend);
        newFriend.friends.add(this);
    }

    public void removeFriend(Person oldFriend) {
        friends.remove(oldFriend);
        oldFriend.friends.remove(this);
    }

    public int numberOfFriends() {
        return friends.size();
    }

    public void disappear() {
        for (Person friend : friends) {
            friend.friends.remove(this);
        }
    }
}