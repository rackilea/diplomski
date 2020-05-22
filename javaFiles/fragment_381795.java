int a;
try {
    a = 1;
    // a is initialised and can be read.
    System.out.println(a); // compiles ok.
} catch (RuntimeException ignored) {
}
// a is not considered initialised as the compiler 
// doesn't know the catch block couldn't be thrown before a is set.
System.out.println(a); // Variable 'a' might not have been initialized

a = 2;
// a is definitely initialised.
System.out.println(a); // compiles ok.