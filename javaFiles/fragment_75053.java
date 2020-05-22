@EventListener({ ContextClosedEvent.class })
public void destroy() {

}


@Component
public class ContextClosed implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(final ContextClosedEvent event) {
       destroy(); // your destroy
    }
}