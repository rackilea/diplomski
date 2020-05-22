class A implements Callback{
    private B b;

    public A(){
        b = new B();
        b.registerCallback(this);
    }    

    // Implementation of the callback interface
    public void call(){

    }
}