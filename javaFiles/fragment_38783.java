@Test
public void testGoogle() throws Exception {
    CompletableFuture<Void> future = new CompletableFuture<>();
    testCases.simpleGoogle(future);
    future.get();
}