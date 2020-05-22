@Component
public class ContextRefreshedHandler implements ApplicationListener<ContextRefreshedEvent> {

  private static Logger logger = LoggerFactory.getLogger(ContextRefreshedHandler.class);

  @Autowired
  private SimpMessagingTemplate template;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    try {
      //Initialize the template for web socket messages
      CommService.setTemplate(template);
    } catch (Exception ex) {
      logger.error(getClass().getName(), ex);
    }
  }
}