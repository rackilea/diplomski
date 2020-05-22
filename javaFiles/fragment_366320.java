public class YourController implements ApplicationContextAware {
ApplicationContext applicationContext;
public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
this.applicationContext = applicationContext;
}
...
}