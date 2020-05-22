static List<User> getAllUsersFromAccount(Account account) {
    return  User.find(
            "SELECT u " +
            "FROM User u " +
            "JOIN FETCH u.account " +
            "WHERE u.account=?", 
            account).fetch();
}