public class ZoppenActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoppen_main);
        final HostnameChecker c = new HostnameChecker();
        c.execute(this);
    }
}