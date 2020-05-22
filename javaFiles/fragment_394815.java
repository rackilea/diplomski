GregorianCalendar expected = new GregorianCalendar();
expected.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2007-08-01 14:40"));

SystemUnderTest subject = SystemUnderTest();

assertEquals(expected, subject.method());