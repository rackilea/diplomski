@Test
public void testSchedulerWithInvalidEntry() {
    GenericResponseWrapper genericResponseWrapper = new GenericResponseWrapper(200, null);
    Mockito.when(facebookAPIWrapper.createNewPost("invalidToken", "123", "invalid")).thenReturn(genericResponseWrapper);
    GenericResponseWrapper testAnswer = facebookAPIWrapper.createNewPost("invalidToken", "123", "invalid");
    assertEquals(200, testAnswer.getStatusCode());
}