public class MainActivity extends AppCompatActivity{

    @Subscribe()
    public void onMessageEvent(MessageEvent event) {
        // Show the message.
    }
}