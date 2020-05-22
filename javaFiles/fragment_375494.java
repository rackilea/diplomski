public class X extends Y {

    @Override
    void method(String s) {
        callsuperMethod();
    }
    void callsuperMethod(){
        super.method(1);
    }

    @Override
    void method(int i) {
        super.method("str");
    }
}