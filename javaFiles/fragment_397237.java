public class ListMatcherTests {

@Test
public void testListMatcherPasses() {
    List<Integer> underTest = Arrays.asList(1, 10, 20);
    assertThat(underTest, ListMatcher.hasAtLeastItemsGreaterThan(2, 5));
}

@Test
public void testListMatcherFails() {
    List<Integer> underTest = Arrays.asList(1, 10, 20);
    assertThat(underTest, ListMatcher.hasAtLeastItemsGreaterThan(2, 15));
}