class UserComparator implements Comparator<User> {
  @Override
  public int compare(User u1, User u2) {
    int compResult = Integer.compare(u1.getEnums().size(), u2.getEnums().size());
    if(compResult == 0)
      compResult = u1.getName().compareTo(u2.getName());
    return compResult;
  }