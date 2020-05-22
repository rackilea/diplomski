Path file = Paths.get("C:\\Users\\Ali Y. Akgul\\Desktop\\150004_15122012_G.txt");

ArrayList<String> lines = Files.readAllLines(file, Charset.defaultCharset());
ArrayList<String []> columns = new ArrayList<>();
for(String line : lines){
    columns.add(line.split('\|'));
}

// Now for each line you have columns.
for(String [] s : columns){ 
    System.out.println(Arrays.toString(s));
}

// To get only the values for column 8 onwards (in response to your comment)
for(String [] s : columns){ 
    String [] sublist = Arrays.copyOfRange(s, 8, s.length);
    System.out.println(Arrays.toString(sublist));
}

// To get only the columns from line 8 onwards
for(int i = 0; i < columns.size(); i++){
    System.out.println(Arrays.toString(columns.get(i)));
}