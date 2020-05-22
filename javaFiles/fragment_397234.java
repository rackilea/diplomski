if(savedInstanceState == null) 
{
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.add(R.id.fragmentContainer, MainMapFragment.newInstance(), "MainMapFragment");
    transaction.commit();
}