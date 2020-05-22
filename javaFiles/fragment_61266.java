List<Long> ids = new ArrayList<Long>();
    ids.add(2L);
    ids.add(5L);
    List<User> userListQuery2 = userDAO.getUsersById(ids);
    for (User user: userListQuery2) {
        System.out.println(user);
    }