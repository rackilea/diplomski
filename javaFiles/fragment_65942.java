class Demo{
    public static void main(String args[]){
        A a1=new B(); 
        System.out.println("a : "+a1.a); //Prints 200  
    }
}
class A{
    int a=100;
}

class B extends A{
     public B() {
        super.a=200;
    }

}