protected void setUp() throws Exception {
    super.setUp();
    rootActivity = (DrawerRootActivity) getActivity();
    rootActivity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
            cf = rootActivity.calculatorFragment;
            cf.changeDigitDisplay(2); // Line 29
            }
    });
}