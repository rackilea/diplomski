public class MyActivity extends FragmentActivity {

    Fragment1 fragment1;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_fragment);
        //as you are using static fragment so create fragment instance using findFragmentById(id)
        fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment1);

        fragment1.setViewText("Message");

    }
}