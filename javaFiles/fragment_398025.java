byte[] arr = new byte[]{1,2,3,4};
    byte[] arr2 = new byte[4];
    for(int i=0; i < 4; i++)
        arr2[i] = arr[i];


    System.out.println("Array 1: " + arr);
    System.out.println("Array 2: " + arr2);
    System.out.println("arr.equals: " + arr.equals(arr2));
    System.out.println("Arrays.equals:  " + Arrays.equals(arr,arr2));
    System.out.printf("Contents of array 1: %s\n", Arrays.toString(arr));
    System.out.printf("Contents of array 2: %s\n", Arrays.toString(arr2));