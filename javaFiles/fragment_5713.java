int[] intArray = new int[] { 0, 1 };
Integer[] integerArray = new Integer[intArray.length];
int i = 0;
for(int intValue : intArray) {
    integerArray[i++] = intValue;
}
intList = new ArrayList<Integer>(Arrays.asList(integerArray));