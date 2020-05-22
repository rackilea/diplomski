for (int i = 0; i < array.length; i++) {
    // Note: this will always be zero because the array elements are all zero to start with
    int counter = array[i]; 
    System.out.println("Enter the element of the array!");
    array[counter] = in.nextInt();
}