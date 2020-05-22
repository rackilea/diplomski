class Foo{
    static{
        System.out.println("test if class will be loaded");
    }
    public static final int x = 42;
}

class Bar{
    public static void main(String [] args){
        System.out.println(Foo.x);
    }
}