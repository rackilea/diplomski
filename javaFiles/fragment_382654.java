@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOptionApplicationTest {

    @Autowired
    private WebApplicationContext context;

    @Test
    public void testFailOnUnknownPropertiesOption() throws Exception {

        final String text = "{\"name\": \"test\", \"title\": \"test\"}";

        MockMvcBuilders
            .webAppContextSetup(this.context)
            .build()
            .perform(post("/test").contentType(MediaType.APPLICATION_JSON).content(text))
            .andExpect(status().isBadRequest());
    }
}