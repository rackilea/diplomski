@Component
public class AppBootstrapListener implements ApplicationListener<ApplicationReadyEvent> {

    //Inject Service or repository if you have.

    /**
    * Executes on application ready event
    * Check's if data exists & calls to create or read data
    */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // code here
    }

}