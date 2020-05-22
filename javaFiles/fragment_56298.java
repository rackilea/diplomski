class Test1 {

    class X {
        static {  <-- compile error: Cannot define static initializer in inner type Test1.X
        }
    }
...