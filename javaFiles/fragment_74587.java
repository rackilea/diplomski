class X
{
    static{   System.out.println("init class X..."); }

    int foo(){ return 1; }

    Y bar(){ return new Y(); }
}