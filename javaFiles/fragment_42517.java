@WebMvcTest(MyController.class) // Controller to unit-test
@Import(WebSecurityConfig.class) // your class extending WebSecurityConfigurerAdapter
public class MyControllerTest extends OAuth2ControllerTest {

    @Test
    public void testWithUnauthenticatedClient() throws Exception {
        api.post(payload, "/endpoint")
                .andExpect(...);
    }

    @Test
    @WithMockOAuth2Client
    public void testWithDefaultClient() throws Exception {
        api.get("/endpoint")
                .andExpect(...);
    }

    @Test
    @WithMockOAuth2User
    public void testWithDefaultClientOnBehalfDefaultUser() throws Exception {
            MockHttpServletRequestBuilder req = api.postRequestBuilder(null, "/uaa/refresh")
                .header("refresh_token", JWT_REFRESH_TOKEN);

        api.perform(req)
                .andExpect(status().isOk())
                .andExpect(...)
    }

    @Test
    @WithMockOAuth2User(
        client = @WithMockOAuth2Client(
                clientId = "custom-client",
                scope = {"custom-scope", "other-scope"},
                authorities = {"custom-authority", "ROLE_CUSTOM_CLIENT"}),
        user = @WithMockUser(
                username = "custom-username",
                authorities = {"custom-user-authority"}))
    public void testWithCustomClientOnBehalfCustomUser() throws Exception {
        api.get(MediaType.APPLICATION_ATOM_XML, "/endpoint")
                .andExpect(status().isOk())
                .andExpect(xpath(...));
    }
}