@Test
public void testHomepageThrows500() throws Exception {

    given(yourService.someMethod()).willThrow(new Exception("something bad happened");

    RequestBuilder requestBuilder = formLogin().user("test@tester.de").password("test");
    mockMvc.perform(requestBuilder).andExpect(redirectedUrl("/home")).andExpect(status().is5xxServerError());
}