@Override
protected void onSaveInstanceState(Bundle outState)
{
    super.onSaveInstanceState(outState);
    FragmentManager manager = getSupportFragmentManager();
    Fragment fr = manager.findFragmentById(R.id.frame_container);
    manager.putFragment(outState, "randomFragment", fr);
}