class UserGroup {
    ArrayList<User> userList;

    UserGroup(){
        userList = new ArrayList<User>();
    }

    public void addSampleData() {
        // ...
        for(int i = 1; i<11; i++) {
            userList.add(getUser(i));
        }
    }
}