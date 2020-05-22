final List<User> users = new ArrayList<>();
users.add(user1);
users.add(user2);
users.add(user3);


Set<Map<String, Integer>> usersSet = 
    users
        .stream()
        .map(u -> Collections.singletonMap(u.getName(), u.getAge()))
        .collect(Collectors.toSet());