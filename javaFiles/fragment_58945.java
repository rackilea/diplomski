final Integer[] list = {5, 1, 3, 2, 8, 1, 3, 9, 5, 0};
Integer[] res = mergeSort(list, (i, j) -> i - j);
System.out.println(Arrays.asList(list));
// [null, null, null, null, null, null, null, null, null, null]
System.out.println(Arrays.asList(res));
// [0, 1, 1, 2, 3, 3, 5, 5, 8, 9]