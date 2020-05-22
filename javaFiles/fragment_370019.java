ConfigurableApplicationContext context;

@Before
public void setup{
    SpringApplication springApplication = new SpringApplicationBuilder()           
            .sources(Application.class)
            .build();
    context = springApplication.run();
}

@After
public void tearDown(){
    SpringApplication.exit(context);
}

@Test
 public void test1(){         
    // action
       ...
    // assertion
       ...
 }