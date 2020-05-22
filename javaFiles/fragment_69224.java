@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private Environment env;

    private String envProperty;

    @Value("${myproperties.property_1}")
    private String valueProperty;

    @PostConstruct
    private void init() {
        this.envProperty = env.getProperty("myproperties.property_1");
    }

    @GetMapping("/mydata")
    public String getMyData() {
        System.out.println("envProperty: " + this.envProperty);
        System.out.println("valueProperty: " + this.valueProperty);
        return "";
    }

    @GetMapping("/myproblem")
    public String getMyProblem() {
        throw new IllegalArgumentException();
    }

}

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApp.class)
public class MyRestControllerTest {

    private MockMvc restMyRestControllerMockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        final MyRestController myRestController = new MyRestController();
//        this.restMyRestControllerMockMvc = MockMvcBuilders.standaloneSetup(myRestController)
//                .build();
        this.restMyRestControllerMockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    public void getMyDataTest() throws Exception {
        restMyRestControllerMockMvc.perform(get("/api/mydata"));
    }

    @Test
    public void getMyProblemTest() throws Exception {
        restMyRestControllerMockMvc.perform(get("/api/myproblem"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isConflict());
    }

}

@ControllerAdvice
public class ControllerAdvicer {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(IllegalArgumentException.class)
    public String assertionException(final IllegalArgumentException e) {
        return "xxx";
    }

}