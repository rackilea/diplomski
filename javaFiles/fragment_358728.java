class StaticsMethodIsNotOverriden2 implements InterfaceWithDefaultMethod {
    public static void main(String[] args) {
        ...
        clazz.superSaySomething(1, 2);
    }

    //a different name/signature needed
    public void superSaySomething(int a, int b) {
        System.out.println(String.format("Forcing super method call with %d %d", a, b));
        //the subclass calls default method
        InterfaceWithDefaultMethod.super.saySomething(a, b); 

    }

    @Override
    public void saySomething(int a, int b) {
        System.out.println(String.format("Overriden method call with %d %d", a, b));
    }

    ...
}