@Test
public testSwappingFirstAndSecondElement() {
  String input[] = { "1", "2"};
  String expectedOutput[] = { "2", "1"};

  assserThat(swap(input, 0, 1), is(expectedOutput));
}