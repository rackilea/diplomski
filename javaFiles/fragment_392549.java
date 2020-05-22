int[] searchInArray = new int[6];
    searchInArray = new int[] { 2, 3, 4, 22, 1, 2 };

    Arrays.sort(searchInArray);
    final int result1 = Arrays.binarySearch(searchInArray, 55);
    final int result2 = Arrays.binarySearch(searchInArray, 22);

    System.out.println("result1 " + result1);
    System.out.println("result2 " + result2);