public void demoArray2() {
    int[] intArray = new int[10];
    int index = 0;
    while (index < 10) {
        intArray[index] = 200 + 2*index;
        index++;
    }
    index = 0;
    while( index < 10) {
        System.out.println("Element at index " + index + " is " + intArray[index]);
        index = index +1;
    }
}