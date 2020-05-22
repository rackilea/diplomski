super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
Bundle bundle = new Bundle();
bundle.putString("my_key", "My String");
MyFragment myFrag = new MyFragment();
myFrag.setArguments(bundle);
getFragmentManager().beginTransaction()
    .add(R.id.fragment_container, myFrag, "myFrag")
    .commit();