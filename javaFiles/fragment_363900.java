while(keepRunning){
    System.out.println("*** NBA MVP Race Administor Account ***");
    System.out.print("\n1.Ranking 2.Update 3.Exit\t- ");
    menuOption = adminInput.nextInt();
    System.out.println("");

    if(menuOption == 1)
    {
        rank.Rank();
    }
    else if(menuOption == 2)
    {
        rank.updateRank();
    }
    else
    {
        keepRunning = false;
    }
}