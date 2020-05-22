public class ChildNavigationActivity extends MyAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_child_navigation);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); //we have included "toolbar" in the parentactivity xml. So not need to do it in childactivity xml.
    /**NOTE: Do Not use "setSupportActionBar(toolbar)" since you have already done it in your parent activity*/
    toolbar.setTitle("ChildNavigationActivity");

    }

}