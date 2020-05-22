String[][] sorted = Arrays.stream(matrix)
                          .sorted((s1,s2)->s1[1].compareTo(s2[1])) // pass the desired index
                          .toArray(String[][]::new);
for(String[] row: sorted){
    System.out.println(Arrays.toString(row));
}