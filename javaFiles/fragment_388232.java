@Test
  public void testName() throws Exception
  {
    List<Integer> actual = new ArrayList<Integer>();
    actual.add(1);
    actual.add(5);
    actual.add(3);
    List<Integer> expected = new ArrayList<Integer>(actual);
    Collections.sort(expected);
    assertThat(actual, contains(expected.toArray()));
  }