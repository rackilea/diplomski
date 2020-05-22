private List<User> getUsers() throws TasteException {
  final int MAX_USERS = 100;
  return dataModel.getUserIDs()
                  .stream()
                  .limit(MAX_USERS)
                  .map(userId -> new User(userId))
                  .collect(Collectors.toList());
}