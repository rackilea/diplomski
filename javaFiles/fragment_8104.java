int[] arr2 = new int[]{54, 432, 53, 21, 43};
int[] sortedArray = Arrays.stream(arr2)
        .boxed()
        .sorted(Comparator.reverseOrder()) // just use 'sorted()' for ascending order
        .mapToInt(Integer::intValue)
        .toArray();