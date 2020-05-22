@Test
public void toStringUnixTime() throws Exception {
  assertEquals("0", Instant.EPOCH.query(UNIX_STRING));
  assertEquals("1491327940.619", Instant.ofEpochMilli(1491327940619L).query(UNIX_STRING));
  assertEquals("1491327940.000012345", Instant.ofEpochSecond(1491327940, 12345).query(UNIX_STRING));
}