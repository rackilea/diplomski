public class MainActivity extends AppCompatActivity {

    private RetainedFragment retainedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            retainedFragment = (RetainedFragment) getSupportFragmentManager().findFragmentByTag(RetainedFragment.TAG);
        }
        else {
            retainedFragment = new RetainedFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(retainedFragment, RetainedFragment.TAG)
                    .commit();
        }
    }

    public RetainedFragment getRetainedFragment() {
        return retainedFragment;
    }
}