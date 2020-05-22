public class ArrayHolder {
    private ObjectA[] arrA;//note that the [] indicates it's an array.

    public ArrayHolder() {
        this.arrA = new Object[10];//Length of ten
        for (int idx=0; idx<10; idx++) {
            this.arrA[idx] = new ObjectA(this);//pass new ObjectA a REFERENCE to 'this' object (ArrayHolder)
        }
    }

    public void doSomething() {
        //This is now callable from all ObjectA objects.
    }
}