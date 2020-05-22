class Foo{
    Foo(){
        doStuff();
    }
    void doStuff(){}
}

class Bar extends Foo{
    private int i = 1;
    @Override
    public void doStuff(){
        System.out.println(i);
    }
}