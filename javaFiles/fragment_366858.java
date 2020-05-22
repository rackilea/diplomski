byte transform(int i){
    if(i == 0)
        return 0x00;

    int lsd = (i % 10); //least significant digit of the input (decimal)
    int msd = (i / 10); //most significant digit

    //merge lsd and msd into a single number, where the lower 4 bits are reserved for
    //lsd and the higher 4 bits for msd
    return lsd | (msd << 4);
}