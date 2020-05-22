public void testIsInputValid() {
    FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
    FragmentTransaction ft = fragmentManager.beginTransaction();
    ft.add(mFragment, null);
    ft.commit();
    getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
            getActivity().getSupportFragmentManager().executePendingTransactions();
        }
    });
    getInstrumentation().waitForIdleSync();
    assertTrue(mFragment.isInputValid());
}