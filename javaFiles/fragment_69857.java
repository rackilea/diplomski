for (int i = 0; i < newMachine.size(); i++) { 
      // newMachine is a terrible name for a list, just saying
      if (newMachine.get(i).getCost() == cost) {
         System.out.println("Machine no: " + i);
         found = true;
         // break; // depends if you just want to find one or all of them
      }
}
if (!found)
    System.out.println("There is no such Ticket Machine");