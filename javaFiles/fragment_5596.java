int[] arr = { 1,2,3,5,8,13,21,34 }

// View of array: 5,8,13,21
int offset = 3, len = 4;
for (int i = 0; i < len; i++)
    System.out.println(arr[i + offset]);