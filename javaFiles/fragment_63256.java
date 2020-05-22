//Firstly, define the size of the subsystem:
    int size = 0;
    for(int i = 0; i < TrueorFalseMatrix.m; i++) {
        if(TrueorFalseMatrix.data[i][0] != 0) 
            size+= 1;
    }
    //Then we can assign the size values to the Matrix of the subsystem
    System_A = Matrix.matrizEmpty(size,size);
    System_B = Matriz.matrizEmpty(size, 1);
    //This array will store the coordinates of the coefficients that
    //will be used
    int[] Coordinates = new int[size];
    //We store these coordinates in the array
    int count = 0;
    for(int i = 0; i < TrueorFalseMatrix.m; i++) {
        if(TrueorFalseMatrix.data[i][0] != 0) {
            Dtrue[count] = i;
            count++;
        }
    }
    //We can now assign values to our system Matrix
    for(int i = 0; i < size; i++) {
        for(int j = 0; j < size; j++) {
            System_A.data[i][j] = SourceMatrix.data[Dtrue[i]][Dtrue[j]];
        }
        System_B.data[i][0] = SourceResultVector.data[Dtrue[i]][0]
    }
    //Results
    double[] Results = System.solve(System_A,System_B);