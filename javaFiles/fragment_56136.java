@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent>{

  @Autowired
  private Environment env;

  private static final Logger log = LoggerFactory.getLogger(MyListener.class);

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    if(env instanceof ConfigurableEnvironment){
      MutablePropertySources propertySources = ((ConfigurableEnvironment)env).getPropertySources();
      for(PropertySource ps : propertySources){
        log.info(ps.getName());  //if only file based needed then check if instanceof ResourcePropertySource
      }
    }
  }
}