class A {
    A(int intForA) { 
        //Do stuff...
    }
}

class B extends A {
    B() {
        this(3);  //Won't compile! A's constructor isn't inherited by B
    }
}