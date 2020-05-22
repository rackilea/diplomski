public class A {
    public static void main(String[] args) {
        B b = new B();
        int[] array = b.getArray();
        // Do something with array
        b.setArray(array);
    }
}

public class B {
    private int[] array;
    public B(){
        array = {0,1,2,3,4}; // Dummy data
    }

    public int[] getArray(){
        return array;
    }

    public void setArray(int[] array){
        this.array = array;
    }
}