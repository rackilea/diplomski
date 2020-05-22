@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
    if (fragment != null) {
        fragment.onActivityResult(requestCode, resultCode, data);
    }
}