@Component
public class CoreServiceFactoryBean {

  @Autowired ApplicationContext ctx;

  public CoreService getBean(String param) {
    CoreService coreService = ctx.getBean("coreService");
    CoreDao coreDao = ctx.getBean("coreDao", parameter);
    coreService.setCoreDao(coreDao);
    return coreService;
  }
}