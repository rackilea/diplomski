Stack of main thread           public static void main(String[] args) {
         |                       Outer outer = new Outer();
         v                     
       Outer<--\
         |\    |
         v \---/
       Inner 

Stack of main thread               outer = new Outer();
         |
         v          
       Outer<--\
         |\ new|
         v \---/
       Inner 

       Outer<--\                   // a reference to the Outer from the Inner
         |\ old|                   // doesn't change the fact that the Outer
         v \---/                   // can't be reached from a GC root.
       Inner                       // Thus the old Outer is eligible for collection (dead)