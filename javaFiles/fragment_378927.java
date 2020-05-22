public class InsertionSortTest extends AbstractSortingTest {

  @Override
  protected ISortingAlgorithm createAlgorithm() {
    return new InsertionSort();
  }
}