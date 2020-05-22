int colIndex  = 2;
    String[][] sorted = Arrays.stream(matrix).sorted((s1,s2)-> {
                            if(s1[colIndex].matches("(\\d+(?:\\.\\d+)?)")){
                                return Double.compare(Double.parseDouble(s1[colIndex]), Double.parseDouble(s2[colIndex]));
                            }
                            else{
                                return s1[2].compareTo(s2[2]);
                            }}) 
                      .toArray(String[][]::new);

    for(String[] row: sorted){
        System.out.println(Arrays.toString(row));
    }