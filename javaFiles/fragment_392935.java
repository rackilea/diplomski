public static void displayLines(int[][] matrix){    
    for (int i = 0; i < matrix.length; ++i){
        System.out.print("Line " + i + " :"); // line header
        for (int j = 0; j < matrix[i].length; ++j){ 
            System.out.print(" " + matrix[i][j]);
        }
        System.out.println(""); // end of line
    }
}