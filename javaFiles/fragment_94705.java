public static void main(String[] arg) {

    Scanner in = new Scanner(System.in);

    int [][] matrix = { // 5 rows, 7 cols
            { 9, 13, 4, 7, 1, 14, 10},
            { 8, 2, 12, 11, 6, 15, 2},
            { 9, 6, 7, 10, 15, 8, 3},
            { 12, 14, 8, 15 ,2 , 7, 8},
            { 12, 10, 3, 11, 8, 3, 5},
    };

    String [] product = new String [5];
    product [0] = "MP3 Player";
    product [1] = "Smart Phone";
    product [2] = "Digital Watch";
    product [3] = "Tablet";
    product [4] ="Portable Gaming System";

    double [] price = {10.75, 15.27, 5.98, 9.67, 4.32, 12.50, 1.42}; // 7 elements

    costOfEach(matrix, product, price);
}

// compute and display the cost of manufacturing each device
public static double costOfEach(int matrix[][], String[] product, double price [] ){
    double cost = 0.00;
    String item = "";
    double maxCost = 0.00;
    double minCost = Double.MAX_VALUE;
    int maxCostIndex = 0;
    int minCostIndex = 0;

    String format = "%-40s$%.2f%n";
    for (int row = 0; row < matrix.length; row++){
         cost = 0;
         for (int col = 0, i = 0; col < matrix[0].length && i < price.length; col++, i++){

             cost += matrix[row][col] * price [i]; 
         }

         System.out.printf(format, product[row] + " cost:", cost);
    }
            return cost;
}