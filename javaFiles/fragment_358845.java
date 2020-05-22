private static int myindex=0; //should start at 0
private static int[] myres={3,6,5};
public int method(){ //also static?
    int res = myres[myindex];
    myindex++;
    if(myindex>=myres.length)myindex=0; 
    return res;
}