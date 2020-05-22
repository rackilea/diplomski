final Collection toRemove = new ArrayList<User>();
for(User user: mFriendList){
    if(user.getUid().equals(dataSnapshot.getKey())){
        toRemove.add(user);
    }
}
mFriendList.removeAll(toRemove);