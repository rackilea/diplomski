@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=WebContextLoader.class, locations = {"classpath:/META-INF/spring/applicationContext.xml", "classpath:/META-INF/spring/applicationContext-test-override.xml", "file:src/main/webapp/WEB-INF/spring/webmvc-config.xml"})
public class MyControllerTest {
@Autowired
WebApplicationContext wac;
MockMvc mockMvc;

@Before
public void setup() {
    this.mockMvc = MockMvcBuilders.webApplicationContextSetup(this.wac).build();
}

@Test
@Transactional
public void testMyController() throws Exception {
    this.mockMvc.perform(get("/mycontroller/add?param=1").accept(MediaType.TEXT_HTML))
    .andExpect(status().isOk())
    .andExpect(model().attribute("date_format", "M/d/yy h:mm a"))
    .andExpect(model().attribute("myvalue", notNullValue()))
    .andExpect(model().attribute("myvalue", hasSize(2)))
    .andDo(print());
}
}