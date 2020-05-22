@Test
public void testGetCurrentUser() throws Exception {
    Principal mockPrincipal = Mockito.mock(Principal.class);
    Mockito.when(mockPrincipal.getName()).thenReturn("me");

    RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get(USER_ENDPOINT_URL)
        .principal(mockPrincipal)
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    MockHttpServletResponse response = result.getResponse();
    int status = response.getStatus();
    Assert.assertEquals("response status is wrong", 200, status);
}