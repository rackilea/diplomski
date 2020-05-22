public abstract class AbstractSortingTest {

  private ISortingAlgorithm algorithm;

  @BeforeAll
  public void setUp() {
    this.algorithm = createAlgorithm();
  }

  protected abstract ISortingAlgorithm createAlgorithm();

  @ParameterizedTest
  @ValueSource(...)
  public void testSorting1(int[] input, int[] expectedResult) {
    assertEquals(expectedResult, this.algorithm.sort(input));
  }
}