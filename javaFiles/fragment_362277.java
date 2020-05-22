class A {
public:
   void f() { 
      B* b = new B();  
      b->doSomething(*this);
   }

   void g() { 
      // ...
   };
};


class B {
public:
   void doSomething(A& a) {
       // You can now access members of a by using the . operator:
       a.g();
   }
};