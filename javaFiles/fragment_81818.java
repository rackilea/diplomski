public class BaseClass implements BaseInterface {

    @Override
    public void method1() {
        System.out.println("BaseClass.method1 IN");
        this.internalMethod3();
        System.out.println("BaseClass.method1 OUT");
    }

    @Override
    public void method2() {
        System.out.println("BaseClass.method2 IN");
        System.out.println("BaseClass.method2 OUT");
    }
    private void internalMethod3() {

        System.out.println("BaseClass.method3 IN");
        System.out.println("BaseClass.method3 OUT");
    }

    @Override
    public void method3() {
        this.internalMethod3();
    }
}