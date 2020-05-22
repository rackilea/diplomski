public class NumberContainer(){

    private int[] elements;
    private int numOfElements;

    public NumberContainer(int size){
        elements = new int[size];
        numOfElements = 0;
    }

    //add a number

    public void add(int x){
        elements[numOfElements] = x;
        numOfElements++;
    }

    //get length
    public int length(){
        return numOfElements;
    }

}