@UiThreadTest
public void testApp() {
  TestApp activity = getActivity();

  Button mGoBtn = (Button) activity.findViewById(R.id.testbutton);
  mGoBtn.performClick();
}