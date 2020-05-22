protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String argument1 = "some information";
        String argument2 = "other information";

        MyFirstFragment fragment = MyFirstFragment.newInstance(argument1, argument2);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
}