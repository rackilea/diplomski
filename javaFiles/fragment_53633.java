List<User> createAndPersistRandomUsers(int count) {
  return IntStream.range(0, count)
    .boxed() // returns Stream<Integer>
    .map(UserBuilder::random) // returns Stream<User>
    .peek(userRepo::persist) // Collateral persist of user, returns Stream<User>
    .collect(toList()); // returns List<User>
}