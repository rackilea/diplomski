public class MyOuterClass {

    MyInnerClass<Integer> myInnerClass;

    public MyOuterClass(){
        myInnerClass = new MyInnerClass<>();  
    }

    public static void main(String[] args) {
        MyOuterClass myOuterClass = new MyOuterClass();
        System.out.println((String)myOuterClass.myInnerClass.myMethod());
    }

    public class MyInnerClass<T> {    
        private class NestedClass {
              public String item = "It works!";
        }

        private final NestedClass nestedClass = new NestedClass();

        public <T> T myMethod() {
             return (T)nestedClass.item; 
        }
    }
}