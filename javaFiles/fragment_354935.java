public Matrix(String fileName){

    //First issue - you are opening a scanner to a file, and not its name.
    Scanner input = new Scanner(new File(fileName)); 
    int rows = 0;
    int columns = 0;

    while(input.hasNextLine()){
        ++rows;
        columns = 0; //Otherwise the columns will be a product of rows*columns
        Scanner colReader = new Scanner(input.nextLine());
        while(colReader.hasNextDouble()){
            //You must "read" the doubles to move on in the scanner.
            colReader.nextDouble();
            ++columns;
        }
        //Close the resource you opened!
        colReader.close();
    }
    double[][]matrix = new double[rows][columns];
    input.close();

    //Again, scanner of a file, not the filename. If you prefer, it's
    //even better to declare the file once in the beginning.
    input = new Scanner(new File(fileName));
    for(int i = 0; i < rows; ++i){
        for(int j = 0; j < columns; ++j){
            if(input.hasNextDouble()){
                matrix[i][j] = input.nextDouble();
            }
        }
    }
}