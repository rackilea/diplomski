ArrayList<ArrayList<Integer>> row = new ArrayList<ArrayList<Integer>>();

for(int j=0; j < 12 ; j++) {
    ArrayList<Integer> column = new ArrayList<Integer>();
    for(int i = 0; i < 12; i++) {
        column.add(0);
    }
    row.add(column);
}