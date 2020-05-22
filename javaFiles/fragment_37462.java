doesExist(email, new UserExistsCallback() {
  @Override
  public void onUserExists(String name) {
    Toast.makeText(AddFriend.this, name, Toast.LENGTH_SHORT).show();
  }
  @Override
  public void onUserDoesNotExist() {
    Toast.makeText(AddFriend.this, "User "+email+" does not exist", Toast.LENGTH_SHORT).show();
  }
});