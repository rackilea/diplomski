class B {
    int fubar(int) throws ExceptionA {
    }

    int frob(int) throws ExceptionA {
         return fubar(int);
    }
}

class D extends B {
    int fubar(int) throws ExceptionB {
    }
}