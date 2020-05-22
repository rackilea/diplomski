if (p1.cont) {
   synchronized(p1) 
   {
       p1.cont = false;
       // p1.notify(); <- do you need this here?
   }
}
table.removeAll();

if (!p2.cont) {
   synchronized(p2)
   {
       p2.cont = true;
       p2.notify();
   }
}