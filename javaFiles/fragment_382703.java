public static <E> void doSomething1(E a){
    //do something
}

//warning : The type parameter Integer is hiding the type Integer
public static <Integer> void doSomething(Integer a){
    // here Integer is generic type and not the usual Integer. You can see the above warning given by the compiler.
    //do something
}