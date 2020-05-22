class Do{
    void doit(){
        ClassA a = new ClassA();
        a.doSomething(new InterfaceA () {
             { System.out.println("Hello world"); }
             @Override public void doSomethingElse() { }
             });
    }
}