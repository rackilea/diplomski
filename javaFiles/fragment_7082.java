public class AccountActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.container);
        AccountFragment fragment = AccountFragment.getInstance(); 
        setInitialFragment(fragment);
    } 

}