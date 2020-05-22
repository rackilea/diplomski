List<UserBudy> buddyList = new <>ArrayList();
Query q = createNativeQuery("SELECT u.id AS id, u.name AS username, u.email AS email "
                          + "FROM user_friends "
                          + "INNER JOIN users AS u "
                          + "ON u.id = '1' "
                          + "WHERE buddyid = '2' "
                          + "AND ACCEPTED = 1 "
                          + "UNION ALL "
                          + "SELECT u.id as id, u.name AS username, u.email AS email "
                          + "FROM user_friends "
                          + "INNER JOIN users AS u "
                          + "ON u.id = '2' "
                          + "WHERE buddyid = '1' "
                          + "AND ACCEPTED = 1");
List<UserBudy> buddyList = (List<UserBudy>)em.getResultList);