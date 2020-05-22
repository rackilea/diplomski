@Component
public class ImagesHandlerImpl implements ImagesHandler, InitializingBean {
  @Override
  public void afterPropertiesSet() throws Exception {
    System.setProperty("java.awt.headless", "false");
  }

  public boolean doScreen() throws Exception {
    //...
  }
}