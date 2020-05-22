public User getUser(int index) throws IndexOutOfBoundsException {
    if(index >= allUsers.size()){
        throw new IndexOutOfBoundsException("User doesn't exist");
    }
    return allUsers.get(index);
}