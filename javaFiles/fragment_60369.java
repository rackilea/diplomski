while (true) {
   if (Gate.atomCustomer.get() < 5) {
     //use museum.tryEnter() instead..
     Museum.getGate(0).enter(this);
     break;
   }
 }