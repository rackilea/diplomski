// 'rows' means the count of your rows which you are going to read.
// if you don't know the rows you need to use a List instead
String[][] matrix = new String[rows][];
int row = 0;
while(scanner.hasNext()) {
    matrix[row] = new String[5];
    for(int i = 0; i < 5;i++) {
        matrix[row][i] = "" + scan.nextInt();
    }
}