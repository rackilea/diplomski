public SpArray(int nNZ){
    spArray = new SpEntry[nNZ];  //nNZ is the number of Non-Zero elements of the sparse matrix

    for (int s=0; s<spArray.length ; s++){
        spArray[s]= new SpEntry(0,0,0) ; 

    }

}