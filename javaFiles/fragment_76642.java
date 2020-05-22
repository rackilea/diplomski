class A {
       int abc = 10;

       public void callme() { 
           System.out.println("In class A");
        }
   }

class B extends A {   
       int abc = 20;  // hidden, not overidden

        public void callme() { 
           System.out.println("In class B");
        }

        public static void main(String [] args) {
        A a = new A();
        a.callme(); // calls A's callme() method. 

        B b = new B();
        b.callme(); // calls B's callme() method.
       }
 }