import java.util.Iterator;

public class EvenNumbers implements Iterable<Integer>{

private int firstNumber;
private int totalNumbers;

public EvenNumbers(int firstNumber, int totalNumbers) {
    this.firstNumber = firstNumber;
    this.totalNumbers = totalNumbers;
}

@Override
public Iterator<Integer> iterator() {
    /***** changed *****/ 
    return new myNewIterator(this.firstNumber,this.totalNumbers);
}

private static class myNewIterator implements Iterator<Integer>{

    private int firstNumber;
    private int totalNumbers;
    private int tmp;

    /***** changed *****/ 
    public myNewIterator(int firstNo,int totalNo) {
         /***** changed *****/
        /****     edited these lines     *******/
        this.firstNumber = firstNo;
        this.totalNumbers = totalNo;
        /***** ****/

        this.tmp = firstNumber - 2;
    }   

    @Override
    public boolean hasNext() {
        if(totalNumbers > 0){
            /***** changed *****/   
            //totalNumbers--; //commenting this line as repeated calls of this line makes this call unsafe
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        /***** changed *****/  
        totalNumbers--;
        tmp = tmp + 2
        return tmp;
    }
}
}