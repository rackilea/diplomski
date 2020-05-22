List<UserPK> userPKs = new ArrayList<UserPK>();
    userPKs.add(new UserPK(1L, "it"));
    userPKs.add(new UserPK(4L, "eng"));
    List<User> userListQuery1 = userDAO.getUsersByIdCombo(userPKs);
    for (User user: userListQuery1) {
        System.out.println(user);
    }