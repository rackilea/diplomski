/**
 * DemoController test class.
 *
 * @since 1.0.0
 */
public class DemoControllerTest extends AbstractMockMvcTest {

    @Value("${url.home}")
    private String urlHome;

    /**
     * Test get username.
     *
     * @throws Exception Exception
     */
    @Test
    public void getUsername() throws Exception {
        // Request.
        resultActions = mockMvc.perform(get(urlHome));
        // Verify response.
        resultActions.andExpect(status().isOk());
    }

}