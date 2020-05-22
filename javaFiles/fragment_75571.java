abstract class A{
    protected A(){
        //constructor code goes here
    }
    public void afterFinalisation(final X x) {
        x.getAList("stuff").add(this);
        x.getAList("otherstuff").add(this);
    }
}

class B extends A{
    protected B(){
        super();
        //constructor code goes here
    }
    public static B create(final X x) {
        final B returnValue = new B();
        returnValue.afterFinalisation(x);
        return returnValue;
    }
}

class C extends A{
    protected C(){
        super();
        //constructor code goes here
    }
    @Override
    public void afterFinalisation(final X x) {
        super.afterFinalisation(x);
        x.getAList("otherstuff").remove(this);
        x.getAList("morestuff").add(this);
    }
    public static C create(final X x) {
        final C returnValue = new C();
        returnValue.afterFinalisation(x);
        return returnValue;
    }
}

class SomeClass{
    private final X someX = new X();

    public A somefunc(final boolean b){
        if(b){
            return B.create(this.someX);
        }else{
            return C.create(this.someX);
        }
    }
}