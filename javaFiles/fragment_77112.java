public static void main(String[] args) {
    System.out.println("NUMBER\tSUM OF SQUARES\tDIVISORS");//setup table
    //loop through numbers 10 to 50
    int sumSquares = 0;
    int numDiv = 0;
    int totalSquares = 0;
    int totalDiv = 0;
    for(int i = 10; i <= 50; i++){ //i represents the integers to print
        sumSquares = sumSquares(i);
        numDiv = numdiv(i);
        System.out.println(i + "\t" + sumSquares + "\t\t" + numDiv);
        totalSquares += sumSquares;
        totalDiv += numDiv;
    }
    System.out.printf("Average sumSquares: %d - Average numDiv: %d", totalSquares/41, totalDiv/41);
}