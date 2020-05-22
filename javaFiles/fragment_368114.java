private final int TOTALNUMS; // It's OK to leave it final - you are allowed to set it in the constructor
...
public IntegerArray(int[] array) {
    nums = array;
    TOTALNUMS = nums.length; // If nums is set to a non-null array, this would not cause an exception
}