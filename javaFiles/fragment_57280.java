public static void getUserById(int id) throws SQLException {
    UserDao dao = new UserDao();
    List<User> users = dao.getUsers(jdbcTemplate);//This return a List or users
    User user = user.stream()
            .filter(u -> u.getId() == id)// filter the user by id
            .findFirst()// if find then return the first
            .orElseGet(User::new);// else return new User()
}