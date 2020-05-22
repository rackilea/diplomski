@Test
public void shouldMatchNumber() {

    // given
    char[] input = { 'a', 'b', 'c', 'd', 'a' };
    char c = 'a';

    // when
    int result = object.MatchNumber(input, c);

    // then
    assertEquals(2, result);
}