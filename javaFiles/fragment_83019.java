@Test
public void checkMoreThan24HoursShouldReturnTrue() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.HOUR_OF_DAY, -25);
    assertTrue(YourClass.dateGreaterThan24Hours(cal.getTime()));
}

@Test
public void checkLessThan24HoursShouldReturnFalse() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.HOUR_OF_DAY, -23);
    assertFalse(YourClass.dateGreaterThan24Hours(cal.getTime()));
}