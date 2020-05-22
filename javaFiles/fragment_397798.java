@Configuration
public class Config {

  @Bean(name = "msg")
  public String msg() {
    return "Test MSG";
  }
}

@Component("testcomp")
public class TestClass {

  private String msg;

  @Autowired
  public TestClass(@Qualifier("msg") String msg)
  {
    this.msg = msg;
  }
}