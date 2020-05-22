public User updateUser(Long userid, Userdto userdto) {
    User user = findByTemplatesFooterNo(userid);
    User mappedUser = modelmapper.map(UserDto, User.class);

    user.setName(mappedUser.getName());
    user.setAge(mappedUser.getAge());

    //user.getPosts().clear(); <-- WHY?
    user.getPosts().addAll(mappedUser.getPost());

    return userrepository.save(user); // <-- return the result of the merge
}