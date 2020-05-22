@Test
void test_execute() {
  Foo f = EasyMock.createMock(Foo.class);

  Capture<Bar> capture = new Capture<Bar>();
  f.setBar(EasyMock.and(EasyMock.isA(Bar.class), EasyMock.capture(capture)));
  execute(f);

  Bar b = capture.getValue();  // same instance as that set inside execute()
  Assert.assertEquals(b.getId(), ???);
}