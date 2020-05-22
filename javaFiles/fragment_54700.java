int array1 [] = {1,2,3,4,5,100,200,400};
int array2 [] = {2,6,5,7,2,5,10};
int array3 [] = {11,65,4,3,2,9,7};
int array4 [] = {111,33,22,55,77};
int[] storeAllArray [] = {array1,array2,array3,array4};

for (int[] array : storeAllArray) {
    System.out.println(Arrays.toString(array));
}