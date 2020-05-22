public SpArray(int nNZ){
    spArray = new SpEntry[nNZ];  //nNZ is the number of Non-Zero elements of the sparse matrix

    SpEntry init = new SpEntry(0,0,0);       // Problem here
    for (int s=0; s<spArray.length ; s++){
        spArray[s]= init ; 

    }

}