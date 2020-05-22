public class A {
    private int a;
    private int b;
    private int c;
    public int s;

    public A(){
        a=5; // In same class
        b=3; // In same class
        c=7;
        s=9;
    }

    public int sum(){
        return a+b; // I can access a and b directly, because we are in the same class with them.
    }

    public getC(){
        return c; // Other classes can read value of c with this public method
    }

    public setC(int value){
        c=value; // Other classes can set value of c with this public method
    }

}


public class B{
    private A obj = new A(); // 

    public void someMethod(){
        int t = obj.getC(); // this is ok
        int g = obj.s; // this is ok because s is public
        int f = obj.c // compiler error, c is private, i can't see it from another class directly
        int p = obj.a // compiler error, a is private, i can't see it from another class directly
    }
}