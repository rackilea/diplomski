User u1 = new User();
u1.setName("Sarah");
u1.setEnums(Collections.emptySet());
User u2 = new User();
u2.setName("Bob");
u2.setEnums(Collections.emptySet());
User u3 = new User();
u3.setName("Peter");
u3.setEnums(EnumSet.of(MyEnum.A, MyEnum.B));
User u4 = new User();
u4.setName("Nicolas");
u4.setEnums(EnumSet.of(MyEnum.A, MyEnum.B));
User u5 = new User();
u5.setName("Paul");
u5.setEnums(EnumSet.of(MyEnum.A));

List<User> users = Arrays.asList(u1, u2, u3, u4, u5);
users.sort(new UserComparator());

// Then split the list and move the users with empty enums at the end
List<User> sortedNonEmptySetUsers = users.stream()
    .filter(u -> !u.getEnums().isEmpty())
    .collect(Collectors.toList());
List<User> sortedEmptySetUsers = users.stream()
    .filter(u -> u.getEnums().isEmpty())
    .collect(Collectors.toList());
sortedNonEmptySetUsers.addAll(sortedEmptySetUsers);

List<User> sortedUsers = sortedNonEmptySetUsers;