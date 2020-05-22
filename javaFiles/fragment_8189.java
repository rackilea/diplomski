@Test
public void testCachig() {
  Pattern first = CompliledPatterns.getPattern("whatever");
  Pattern second = CompliledPatterns.getPattern("whatever");
  assertThat(first, isSame(second));
}