@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    loginFragment = new LoginFragment();
    getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.fragment_container, loginFragment, "fragment_container")
            .commit();
}