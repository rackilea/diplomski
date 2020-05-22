private List<User> getUsers() throws TasteException {
  final int MAX_USERS = 10;
  return StreamSupport.stream(Spliterators.spliteratorUnknownSize(dataModel.getUserIDs(), 0), false)
                      .limit(MAX_USERS)
                      .map(userId -> new User(userId))
                      .collect(Collectors.toList());
}