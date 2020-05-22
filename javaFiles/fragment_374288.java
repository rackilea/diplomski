@Test
public void testGetIt() throws Exception {
    BookOfFriendsAnswer responseMsg
            = target.path("book").request().get(BookOfFriendsAnswer.class);
    System.out.println(responseMsg);
}