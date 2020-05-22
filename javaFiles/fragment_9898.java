public abstract class A {


    public abstract void method();

}

public class B extends A{
    public  void method(){
        //code
    }
}

public class C extends A {
    public  void method(){
        //code
    }
}

public class Main{

    public static void main(String args[]){
        ArrayList<A> obj=new ArrayList<A>();
        obj.add(new B());
        obj.add(new C());
        for (A a : obj) {
            a.method(); // it will call respective method of B and C class
        } 
    }        

}