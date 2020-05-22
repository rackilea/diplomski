private Map<Integer, UserObject> tempUsers = new HashMap();

//helper method that uses Stream to find and return existing UserObject
private UserObject getUser(int id){
    return users.get(id);
}