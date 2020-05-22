void whatever(int a) {
    a = 5;
}
void someMethod() {
    int foo;

    foo = 3;
    whatever(foo);
    System.out.println(foo); // Prints 3, of course, not 5
}