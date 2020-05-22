class CustomListBox extends ListBox {
    public void addUsersList(List<User> userList) {
        for (User user : userList) {
            addItem(user.toString());
    }
}

CustomListBox customListBox = new CustomListBox();
customListBox.addUsersList(getUsersList());
customListBox.setValue(getUsersList().get(1));