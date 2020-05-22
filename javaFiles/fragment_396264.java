@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    requestCode &= 0xffff;
    for (Fragment fragment : getSupportFragmentManager().getFragments()) {
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }
    super.onActivityResult(requestCode, resultCode, data);
}