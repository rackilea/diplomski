@Test
public void test() {
    RestTemplate restTemplateMock = Mockito.spy(RestTemplate.class);
    Mockito.doReturn(null).when(restTemplateMock).getForObject(Mockito.anyString(), Mockito.eq(TokenRequestorPayload.class));

    // more code

    instance.getTokenRequestor(id, restTemplateMock); // passing in the mock
}