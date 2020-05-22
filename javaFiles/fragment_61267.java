List<String> groups = new ArrayList<String>();
    groups.add("it");
    groups.add("eng");
    List<User> userListQuery3 = userDAO.getUsersByGroup(groups);
    for (User user: userListQuery3) {
        System.out.println(user);
    }