public class Buffer {
private int size;
private int inPtr = 0;
private int outPtr = 0;
private int counter = 0;
private Order[] data; 


public Buffer(int size) {
    this.size = size;
    this.data = new Order[size];
}

public synchronized String remove(){
    // removes the revote for the officer 
    Order out;
    out = data[outPtr];
    outPtr = (outPtr+1)%size;
    counter--;
    return " Food: " + out.getFoodId() + " ordered by TillId: " + out.getTillId();
}
public synchronized void insert(Order i){
    // inserts a new vote 
    data[inPtr] = i;
    inPtr = (inPtr+1)%size;
    counter++;
}
public synchronized boolean isEmpty(){
    // returns true if empty
    return counter==0;
}
public synchronized boolean isFull(){
    // returns true if full
    return counter==size;
}


}