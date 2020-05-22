static Foo changeFoo(Foo f){
    return new Foo(512);
}
public static void main(String[] args){
    Foo f = new Foo(100);
    f = changeFoo(f);
    System.out.println("f is " + f.getNum());
}