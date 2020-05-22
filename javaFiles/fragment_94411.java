public static void main(String[] arg) throws Exception {

    // NESTED ARRAYS EXAMPLE
    List<int[][]> nestedlist = Arrays.asList(
        new int[][] { new int[] {1, 3}, new int[] {2, 5} },
        new int[][] { new int[] {4, 8}, new int[] {3, 1} },
        new int[][] { new int[] {5, 9}, new int[] {6, 5} }
    );

    String s = makeStringForNestedArrays(nestedlist);
    System.out.println(s);

    List<Integer[][]> readNestedList = parseStringToNestedArrays(s);
    System.out.println(Arrays.deepToString(readNestedList.toArray()));


    // SIMPLE ARRAYS EXAMPLE
    List<Integer> simpleList = Arrays.asList(1, 3, 5, 6);

    s = makeStringForSimpleList(simpleList);
    System.out.println(s);

    List<Integer> readSimpleList = parseStringToSingleList(s);
    System.out.println(readSimpleList);

  }

  private static String makeStringForSimpleList(List<Integer> list) {
    return list.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }

  private static List<Integer> parseStringToSingleList(String s) {
    return Arrays.stream(s.split(" ")).map(Integer::valueOf).collect(Collectors.toList());
  }

  private static String makeStringForNestedArrays(List<int[][]> list) {
    return list.stream().
        map(arrayOfArrays -> arrayOfArraysToString(arrayOfArrays))
        .collect(Collectors.joining(" | "));
  }

  private static List<Integer[][]> parseStringToNestedArrays(String s) {
    return Arrays.stream(s.split(" \\| "))
        .map(str -> stringToArrayOfArrays(str, " ~ ", " "))
        .collect(Collectors.toList());
  }

  private static String arrayToString(int[] array) {
    return Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
  private static String arrayOfArraysToString(int[][] arrayOfArrays) {
    return Arrays.stream(arrayOfArrays).map(array -> arrayToString(array)).collect(Collectors.joining(" ~ "));
  }


  private static Integer[] stringToArray(String s, String delimiter) {
    String[] a = s.split(delimiter);
    return Arrays.stream(a).map(Integer::valueOf).toArray(Integer[]::new);
  }
  private static Integer[][] stringToArrayOfArrays(String s, String delimiterLevel1, String delimiterLevel2) {
    String[] a = s.split(delimiterLevel1);
    return Arrays.stream(a).map(s1 -> stringToArray(s1, delimiterLevel2)).toArray(Integer[][]::new);
  }