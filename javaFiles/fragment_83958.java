String blargString = Double.toString(blarg);
    String inputString = Double.toString(input);
    ArrayList<Integer[]> indexNumberList = new ArrayList<Integer[]>();
    int n = 0;
    for (char c : blargString.toCharArray()) {
        n++;
        if (c == inputString.toCharArray()[n]) {
            Integer[] entry = new Integer[2];
            entry[0] = n;
            entry[1] = Character.getNumericValue(c);
            indexNumberList.add(entry);
        }
   }