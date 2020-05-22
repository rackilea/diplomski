public static String[] runTeams (String CPUcolor) 
{  
    boolean z = false ; 
    String[] a = null; // define a here, assign to null value
    boolean CPU = false ; 
    while (z == false) 
    { 
        while (CPU==false) 
        {
            a = assignTeams () ; // assign a here
            printOrder (a) ;

            for (int i = 1; i<a.length; i++) 
            { 
                if (a[i].equals(CPUcolor)) CPU = true ;
            }
            if (CPU==false) 
            {
                System.out.println ("ERROR YOU NEED TO INCLUDE THE COLOR OF THE CPU IN THE TURN ORDER") ; 
            }
        }
        System.out.println ("is this turn order correct? (Y/N)") ; 
        String s = getIns () ; 
        while (!((s.equals ("y")) || (s.equals ("Y")) || (s.equals ("n")) || (s.equals ("N")))) 
        {
            System.out.println ("try again") ; 
            s = getIns () ; 
        } 
        if (s.equals ("y") || s.equals ("Y") ) 
        z = true ; 
    } 
    return a ; 
}