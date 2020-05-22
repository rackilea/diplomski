@Override
public void navigateFragment() {
    mViewProfileFragment = new ViewProfileFragment();

    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.add(R.id.main_content_frame, mViewProfileFragment, getString(R.string.tag_fragment_view_profile));
    transaction.commit();
}