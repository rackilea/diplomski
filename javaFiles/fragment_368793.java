public void testApp2() throws Throwable {
  TestApp activity = getActivity();

  final Button mGoBtn = (Button) activity.findViewById(R.id.testbutton);
  runTestOnUiThread(new Runnable() {

    @Override
    public void run() {
      mGoBtn.performClick();
    }
  });
}