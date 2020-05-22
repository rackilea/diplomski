public EightQueen(int size) {
    //Initialize the object
    queenOnSquare=new boolean[size][size];
    colEmpty=new boolean[size];
    upDiagEmpty=new boolean[2*size-1];
    downDiagEmpty=new boolean[2*size-1];
    bordersize=size;
    numOfSol=0;
    for (int i=0;i<bordersize;i++){
        colEmpty[i]=true;
    }
    for (int i=0;i<2*bordersize-2;i++){
        upDiagEmpty[i]=true;
        downDiagEmpty[i]=true;
    }
}