private boolean nrCheck()
{   
    Scanner sc = new Scanner (System.in);

    System.out.println("New Release [Y/N]? ");      
    String movieType = sc.nextLine();       

    switch (movieType)
    {
        case "Y" : case "y" : return true;
        case "N" : case "n" : return false;
        default  : return nrCheck();
    }
}