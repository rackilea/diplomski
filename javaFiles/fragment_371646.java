@Test
public void testSaveUser(){

    User user1 = new User();
    user1.setUsername("user_1");

    User user2 = new User();
    user2.setUsername("user_2");

    User user3 = new User();
    user3.setUsername("user_3");

    user1.addFriend(user2);
    user2.addFriend(user3);

    dao.saveUser(user1);
}