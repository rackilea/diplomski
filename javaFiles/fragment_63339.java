public class MyClass {

   public static void main(String[] args) {
    MyClass my = new MyClass(3,4);
    MyClass your = new MyClass();   
   }


    private final int a,b; 

     public Myclass() {
        this(1,2);
    }

    public Myclass(int a, int b) {
        this.a = a;
        this.b = b;
    }

}