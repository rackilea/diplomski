public class BetterActivity extends Activity {
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateNoSuper(savedInstanceState);
    }
    // could be abstract as well.
    protected void onCreateNoSuper(Bundle savedInstanceState) {}
}