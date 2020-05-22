if (nums.length != numsCopy.length)
   throw new IllegalArgumentException("Arrays are not the same length");

IntPredicate elementsEqual = i -> nums[i] == numsCopy[i];
int first = IntStream.range(0, nums.length)
    .dropWhile(elementsEqual)
    .findFirst()
    .getAsInt();
int last = IntStream.iterate(nums.length - 1, i -> i >= first, i -> i - 1)
    .dropWhile(elementsEqual)
    .findFirst()
    .getAsInt();
int count = last - first + 1;