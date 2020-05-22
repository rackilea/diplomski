public CreateBlockArray(){

//get coordinates 

    //fill array        
    int[][][] blockarray = new int[Xdelta+ 10][Ydelta + 10][Zdelta + 10];

    blockarray = fillarray(Xlow,Ylow, Zlow, Xhigh, Yhigh, Zhigh, blockarray   );
    blockarray = getvisibleBlocks(Xlow,Ylow, Zlow, Xhigh, Yhigh, Zhigh, blockarray);    
    blockarray = filloceanfloor(Xlow,Ylow, Zlow, Xhigh, Yhigh, Zhigh, blockarray);  
    //these three methods modify array and than return it

}