class A {
    int nonStatic = 7; 
     static void m( A a ) {
            a.nonStatic = 12;
     }
}