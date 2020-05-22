@Test
public void testEventListener() {
  ActionListener subjectUnderTest = new MyActionListener();
  ActionEvent mockEvent = mock(ActionEvent.class);
  // Or just create a new ActionEvent, e.g. new ActionEvent();
  // setup mock

  subjectUnderTest.actionPerformed(mockEvent);

  // validate
}