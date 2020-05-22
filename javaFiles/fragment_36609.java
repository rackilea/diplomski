public class A {

    public A(B classB){
        this.classB = classB;
    }

    public void printValue(){
        System.out.println(this.classB.getTest());
    }
}