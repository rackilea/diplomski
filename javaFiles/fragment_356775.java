String[][] arr = 
    map.entrySet()
       .stream() // Stream<Map.Entry<String,String>>
       .map(e -> new String[] {e.getKey(),e.getValue()}) // Stream<String[]>
       .toArray(String[][]::new); // String[][]
System.out.println(Arrays.deepToString (arr));