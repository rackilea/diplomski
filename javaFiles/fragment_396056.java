private ArrayList<User> data;
...
public void setData(User data) {
    if (this.data == null) {
        this.data = new ArrayList<User>();
    }
    this.data.add(data);
}