public class AuthenticationControllerTest extends WebTestConfigAware {

  @Test
  public void testAuthenticationRequest() throws Exception {
    AuthenticationRequestDto authentication = new AuthenticationRequestDto();
    authentication.setUsername("admin");
    authentication.setPassword("Test1234");

    String jsonAuthentication = TestUtil.convertObjectToJsonString(authentication);

    ResultActions res = mockMvc.perform(post("/auth")
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonAuthentication));

    res.andExpect(status().isOk());

  }