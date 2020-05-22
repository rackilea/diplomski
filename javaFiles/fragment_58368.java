int[][] iArray = new int[list.size()][]; // create outer array
for (int i = 0; i < list.size(); i++) {
    ArrayList<Integer> subList = list.get(i);
    iArray[i] = new int[subList.size()]; // create sub-array
    for (int j = 0; j < subList.size(); j++)
        iArray[i][j] = subList.get(j);   // copy value
}