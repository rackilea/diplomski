import org.springframework.context.ApplicationListener;

@Component
public class myLoginListener implements ApplicationListener<ApplicationEvent> {

public void onApplicationEvent(ApplicationEvent appEvent)
{
    if (appEvent instanceof AuthenticationSuccessEvent)
    {
        AuthenticationSuccessEvent event = (AuthenticationSuccessEvent) appEvent;
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();

        //track the logged in Users here ....
    }
}