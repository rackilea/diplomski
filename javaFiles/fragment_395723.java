@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TemplateConfig.class})
@WebAppConfiguration

@Autowired
WebApplicationContext wac;

@Before
public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
}