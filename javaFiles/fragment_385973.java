@Component
public class MyServiceCreationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
      // do something on container startup
    }
}