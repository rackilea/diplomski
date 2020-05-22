protected User getUser(DirContext context, String username,
                       String credentials, int curUserPattern)
    throws NamingException {
    ...
    if (userPatternFormatArray != null && curUserPattern >= 0) {
        user = getUserByPattern(context, username, credentials, attrIds, curUserPattern);
    } else {
        user = getUserBySearch(context, username, attrIds);
    }
    if (userPassword == null && credentials != null) { //Line 1300;No null check for 'user' object.
        return new User(user.getUserName(), user.getDN(), credentials,
                user.getRoles(), user.getUserRoleId());
    }
    return user;
}