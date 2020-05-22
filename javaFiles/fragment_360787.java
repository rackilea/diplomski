public void showDialogFragment(Fragment targetFragment, AppCompatDialogFragment appCompatDialogFragment, int requestCode) {
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
    appCompatDialogFragment.setTargetFragment(targetFragment, requestCode);
    fragmentTransaction.add(appCompatDialogFragment, appCompatDialogFragment.getClass().getSimpleName());
    fragmentTransaction.commitAllowingStateLoss();
}