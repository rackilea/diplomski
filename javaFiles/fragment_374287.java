@Test
public void testGetIt() throws Exception {
    String responseMsg = target.path("book").request().get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    BookOfFriendsAnswer books = mapper.readValue(
            responseMsg, BookOfFriendsAnswer.class);
    System.out.println(books);
}