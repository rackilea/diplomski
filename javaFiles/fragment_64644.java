public UserItem UserToUserItem(User user) {
    UserItem userItem = new UserItem();
    userItem.setUserId(user.getUserId());
    userItem.setGroupId(user.getGroup().getGroupId());
    userItem.setName(user.getName());

    return userItem;
}