public void openFragment(CustomParcelable parcelableObject, long objectID) {
    FragmentA fragmentA = new FragmentA();
    Bundle bundle = new Bundle();
    bundle.putParcelable(FragmentA.KEY1, parcelableObject);
    bundle.putLong(FragmentA.KEY2, objectID);
    fragmentA.setArguments(bundle);
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.fragmentContainer, fragmentA);
    transaction.commitAllowingStateLoss();
}