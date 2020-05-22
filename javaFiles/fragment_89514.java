class foo {
    int x = 1;      // this is a class-level variable
    public foo() {
        bar1();
        System.out.println(x);  // result: 1
        bar2();
        System.out.println(x);  // result: 2
    }
    public void bar1() {
        int x = 2;  // This instantiated a new 
                    // local variable "x", it did not 
                    // affect the global variable "x"
    }
    public void bar2() {
        x = 2;      // This changed the class var
    }
}