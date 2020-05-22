@Test
public void testSuccessfulLogin() throws Exception {
    RequestBuilder requestBuilder = formLogin().user("test@tester.de").password("test");
    mockMvc.perform(requestBuilder).andExpect(redirectedUrl("/home")).andExpect(status().isFound());
}

@Test
public void testHomepageThrows500() throws Exception {

    // configure a mock service in the controller to throw an exception

    RequestBuilder requestBuilder = formLogin().user("test@tester.de").password("test");
    mockMvc.perform(requestBuilder).andExpect(redirectedUrl("/home")).andExpect(status().is5xxServerError());
}