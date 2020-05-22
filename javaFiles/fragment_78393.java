List<int[]> listOfIntArrays = new ArrayList<int[]>();
listOfIntArrays.add(new int[] { 10, 20, 30 });
listOfIntArrays.add(new int[] { 11, 21, 31 });
listOfIntArrays.add(new int[] { 12, 22, 32 });

int[][] intMatrix = listOfIntArrays.toArray(new int[0][]);

System.out.println(Arrays.deepToString(intMatrix));