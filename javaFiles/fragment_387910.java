public class B extends A{
    public String foo(String s){
        return s+s;
    }

    public A getA(boolean flag){
        if (flag){
            A a = new A();
            return(a);
        }
        else{
            B b = new B();
            return (b);
        }
    }
}