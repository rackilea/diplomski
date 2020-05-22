public class F2 extends FragmentActivity{

    // Sending "Hello from F2" to anyone listening.
    public void sendMessage() {
        MessageEvent event = new MessageEvent("Hello from F2");
        EventBus.getDefault().post(event);
    }
}