private void doServiceComplete()
{
  sim.serviceComplete();

  if(sim.notBeingServed() == true)
  {
     System.out.println("No customer is being served at the present time"
           + " of " + sim.getTime() + ".");
  }
  else
  {
     System.out.print("Customer " + sim.getCurCust().toString() + 
           " finished at time " + sim.getTime() + ". Number waiting" + 
           " is ");
     System.out.println(sim.getNumWaiting() + ".");
  }
}