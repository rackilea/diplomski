final Iterator<User> iterator = mFriendList.iterator();
while(iterator.hasNext()) {
    final User user = iterator.next();
    if(user.getUid().equals(dataSnapshot.getKey())) {
        iterator.remove();
    }
}