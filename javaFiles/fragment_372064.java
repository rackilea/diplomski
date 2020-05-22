class C { 
    public String cvariable; 
    public void cfunction(){ 
        System.out.println("string");   
    }
} 

class A { 
    public C c1; 
    public void funtiona(){ 
        c1 = new C(); 
    } 
} 

public class B extends A { 
    public void functionb(){ 
        c1.cfunction(); 
    } 
    public static void main(String args[]){ 
        B b = new B(); 
        b.functionb(); 
    } 
}