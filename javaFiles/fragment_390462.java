int[] array = new int[]{0,1,2,3,4,5,6,7};
int[] sortedArray = new int[8];
for(int i = 0; i < array.length; i+=2){
    sortedArray[i] = array[i/2];
    sortedArray[i + 1] = array[array.length - i/2 - 1];
}
System.out.println(Arrays.toString(sortedArray)); // prints [0, 7, 1, 6, 2, 5, 3, 4]