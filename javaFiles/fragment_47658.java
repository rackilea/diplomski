@Test
public void testTimestampVsDate() {
    java.util.Date date = new java.util.Date();
    java.util.Date stamp = new java.sql.Timestamp(date.getTime());
    assertTrue("date.equals(stamp)", date.equals(stamp));            //TRUE
    assertTrue("stamp.compareTo(date)", stamp.compareTo(date) == 0); //TRUE
    assertTrue("date.compareTo(stamp)", date.compareTo(stamp) == 0); //FALSE
    assertTrue("stamp.equals(date)", stamp.equals(date));            //FALSE
}