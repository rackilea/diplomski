@Test
public void shouldReturnAbcWhenSomeArgumentUsed() {
  //given
  Object arg = arg1;

  //when
  Set<Object> result = method(arg);

  //then
  assertThat(result).containsExactly(a, b, c);
}