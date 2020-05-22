public void setData(ArrayList<User> data) {
    this.data = data;
}

public void addUser(User data) {
    if (this.data == null) {
        this.data = new ArrayList<User>();
    }
    this.data.add(data);
}