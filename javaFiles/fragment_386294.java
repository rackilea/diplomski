public class SomeCollection {
   public void add(int value) {
      insertArray = expandIfNeeded(insertArray);
      insertArray[insertIndex++] = value;
      sortArray = expandIfNeeded(sortArray);
      sortArray[sortIndex++] = value;
      sort(sortArray);
   }
   ...
}