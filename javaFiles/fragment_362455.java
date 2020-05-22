public class JerseySpringResourceTest extends JerseyTest {

    // ... Configure ...

    @Before
    public void mockUp() throws Exception {
        // ApplicationContext is ready in your @Before methods ...
        assertThat(ApplicationContextUtils.getApplicationContext(), notNullValue());
    }

    @Test
    public void testJerseyResource() {
        // ... as well as in your test methods.
        assertThat(ApplicationContextUtils.getApplicationContext(), notNullValue());
    }
}