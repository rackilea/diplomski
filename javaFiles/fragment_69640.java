public void getFriendshipChain(final Person from, final Person to, final List<Person> friendshipChain) {

    friendshipChain.add(from);

    // We have found the target person, return
    if (from.equals(to)) {
        return;
    }

    // For every friend from that person
    for (Person friend : from.getFriendChain()) {

        // If we don't already have it in the list
        if (!friendshipChain.contains(friend)) {

            // follow this friend's chain
            getFriendshipChain(friend, to, friendshipChain);

        }
    }

}