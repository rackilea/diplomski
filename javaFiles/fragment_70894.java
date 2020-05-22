@Test
public void testIt() {
    withServer(defaultSetup(), server -> {
        UsersService service = server.client(UsersService.class);
        RegUserStatus created = service.addUser("aaa").handleRequestHeader(
                rh -> rh.withHeader("Referer" ,"winter")
        ).invoke(new NewUser("aaa")).toCompletableFuture().get(5, SECONDS);
        assertEquals(true, created.ok); // default greeting

    });
}