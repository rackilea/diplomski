List<User> userList = new ArrayList<>();
    userList.add(new User("user1", "password1"));
    userList.add(new User("user2", "password2"));
    userList.add(new User("user3", "password3"));
    userList.add(new User("user4", "password4"));
    ObjectMapper mapper = new ObjectMapper();
    String string = mapper.writeValueAsString(userList);