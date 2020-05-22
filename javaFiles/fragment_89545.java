@Autowired
private Environment env;

env.getProperty("testing");
env.getProperty("foo.bar");

//OR
@Value(${"foo.bar"})
private String valueFromFooBar