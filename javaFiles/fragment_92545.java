public void printTo100(){
    int[] array = new int[101];
    try{
        printToArrayLimit(array, 1);
    }catch(ArrayIndexOutOfBoundsException e){
    }
}
public void printToArrayLimit(int[] array, int index){
    array[index] = array[index-1]+1;
    System.out.println(array[index]);
    printToArrayLimit(array, index+1);
}