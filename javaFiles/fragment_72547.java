interface IExample {
   // you can use interfaces if you need them
   void method1();
}

enum Example implements IExample {
    ex1 {
        public void method1() {
            // do stuff
            method2();
        }
        public void method2() {
            // do other stuff
        }
    },
    ex2 {
        public void method1() {
            // do stuff
            method2();
        }
        public void method2() {
            // do other stuff
            method3(); // not all methods need to be different.
        }
    };

    public abstract void method1(); // only needed if you don't use an interface
    public abstract void method2(); // does it need to be public as well?
    public void method3() { /* added as an example */ }
}