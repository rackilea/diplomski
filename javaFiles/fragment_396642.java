public class MainActivity extends Activity implements MyListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Blah blah blah
        Server.setListener(this);
    }

    @Override
    public void a(int data) {
        // You can receive the data here
    }

}