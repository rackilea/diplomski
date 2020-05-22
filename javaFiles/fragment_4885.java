public class MyStack extends Stack<myObject> {

    public void printStack() {
        Iterator<myObject> iter = this.iterator(); // *** here***
        while(iter.hasNext()) {
            myObject temp = iter.next();
            System.out.print(temp.toString());
        }
    }