final int col = 6;
final int rows = numbers.size() % col == 0 ? numbers.size() / col : numbers.size() / col + 1;
double[][] deneme = new double[rows][col];
for (int i = 0; i < rows; i++) {
    for (int k = 0; k < col; k++) {
        if (i == rows - 1 && k >= numbers.size() % col) // UPDATE: last line may not contain `col` sized elements
            break;
        deneme[i][k] = numbers.get(k + col * i);       
        System.out.print( deneme[i][k]+ " ");
    }// for k end
    System.out.println(); // go to next line
} // for i end