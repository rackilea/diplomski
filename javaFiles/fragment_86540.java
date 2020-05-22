@Test
public void testCalendar() throws InterruptedException {
  Calendar cal1 = Calendar.getInstance();
  Thread.sleep(1000);
  Calendar cal2 = Calendar.getInstance();
  DateFormat df = new SimpleDateFormat("yyyyMMdd-hh:mm:ss.SSS");
  String s1 = df.format(cal1.getTime());
  String s2 = df.format(cal2.getTime());
  assertEquals(s1, s2);
}