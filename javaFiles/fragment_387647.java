public void timePasses()
{
    House callgo = new House();

    System.out.println("Shower usage:\n");    
    for (int x = 0; x < 4; x++) 
    {
    callgo.goShower();

    //Need to stop here, System.out.println("Cooker usage:\n"); only needs to print once.
    }
    System.out.println("Cooker usage:\n");
    for (int z = 0; z < 4; z++) 
    {
    callgo.goCooker();
    }

  //this method is called as part of the simulation to trigger a new fifteen minute period
  //in the house. When it is called, it will in turn call timePasses() on all the Appliances in the House.
}