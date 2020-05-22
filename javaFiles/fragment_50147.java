public class MyEventHandler implements ApplicationListener<StateEvent> {

    public void onApplicationEvent(StateEvent event) {
        System.out.println(event);
    }
}