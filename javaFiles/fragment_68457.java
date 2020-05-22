public void changeFragment(Fragment f)
{
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(android.R.id.content, f);
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.commit();
}