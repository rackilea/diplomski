public class MyClass {
    DoWork dw;
    public MyClass(DoWork dw) {
        this.dw = dw;
    }
    public void startWork(String s){
        dw.doit(s);
    }

}