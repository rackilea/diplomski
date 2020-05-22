@Component
public class ServerReadyClass implements  ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //YOUR LOGIC
    }
}