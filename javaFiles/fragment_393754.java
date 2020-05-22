@Override
public void onCreate(Bundle savedInstanceState)
{
    // I assume you accidentally left out these lines
    super.onCreate(savedInstanceState);
    setContentView(R.id.your_content_view);

    if (savedInstanceState == null) {
        FragmentA fragA = new FragmentA();
        FragmentTransaction fragmentTransaction = 
        getSupportFragmentManager().beginTransaction();
        fragmentTransation.replace(R.id.basic_frame, fragA);
        fragmentTransaction.commit();
    }
}