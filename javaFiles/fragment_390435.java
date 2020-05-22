public void setUserList(List<UserList> userList) {
    userList.clear();
    this.userList  = userList;
    notifyDataSetChanged();

}