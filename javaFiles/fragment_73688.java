class AppSuperClass {

    public final void print(SuperClass superClass) {
        if (superClass is SubClass) {
            printImpl((SubClass) superClass);
        } else {
            printImpl(superClass);            
        }
    }

    protected void printImpl(SuperClass superClass) {
        ...
    }

    protected void printImpl(SubClass subClass) {
       ...
    }
}