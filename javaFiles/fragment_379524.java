context.checking(new Expectations() {{
  allowing(calculator).add(1, 2);
  will(returnValue(3));

  DateTime loadTime = new DateTime(12);
  DateTime fetchTime = new DateTime(14);
  allowing(reloadPolicy).shouldReload(loadTime, fetchTime);
  will(returnValue(false));
}});