public class MainActivity extends AppCompatActivity {

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new HomeFragment());
    }


         public void replaceFragment(final Fragment fragment) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                        .commit();
            }

            public void addFragment(final Fragment fragment) {
                final Fragment hideFragment = getFragmentManager().findFragmentById(R.id.container);
                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, fragment, fragment.getClass().getSimpleName())
                        .hide(hideFragment)
                        .addToBackStack(hideFragment.getClass().getSimpleName())
                        .commit();
            }
    }