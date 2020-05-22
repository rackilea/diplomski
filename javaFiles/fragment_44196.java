import org.junit.BeforeClass;

....

    /**
     * Runs the application server before every scenario.
     */
    @BeforeClass
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }