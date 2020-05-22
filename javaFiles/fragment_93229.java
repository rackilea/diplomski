/** @return The list of friends, not null */
public List<String> getFriends() {
    if (friends == null) {
        friends = new ArrayList<>();
    }
    return friends;
}