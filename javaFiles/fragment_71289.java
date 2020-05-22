Session session = null;
    session = sessionFactory.openSession();
    String query = "select users.username, users.password, users.name, users.enabled, users.surname, users.email, users.gender, users.age, users.weight, users.height, users.sport, users.place, users.photo from users where users.username LIKE '%s'";
    List<Users> userInfoList = session.createSQLQuery(String.format(query, username)).addEntity(Users.class).list();
    session.close();
    session = null;