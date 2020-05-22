public class SomeClass {
    int x; //field
    public void someMethod(int a, int b) {
        int x = a + b;
        //this refers to the variable in the method
        System.out.println(x);
        //this refers to the variable in the class i.e. the field
        //recognizable by the usage of this keyword
        System.out.println(this.x);
    }
}