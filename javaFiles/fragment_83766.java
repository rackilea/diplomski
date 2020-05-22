int rowLength = 10, columnLength = 5; //Initialize sizes
ArrayList<String[]> data = new ArrayList<String[]>();

for (int row = 0; row<rowLength; row++) {
    String[] stringsColumn = new String[columnLength];
    for (int col = 0; col <columnLength; col++) {
        stringsColumn[col]=Integer.toString(col);
    }
    data.add(stringsColumn);
}