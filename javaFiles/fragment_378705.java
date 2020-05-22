class A {
        public abstract int add(int a,int b); //just declaration- no body
    }
    class B extends A {
        /*must override add() method because it is abstract in class A i.e class B must have a body or definition of add()*/ 
        int a, b;
        public int add(int a,int b) {
            this.a = a;
            this.b = b;
            return a + b;
        }
    }