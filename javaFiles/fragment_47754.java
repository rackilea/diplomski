public Person3(String [] theName, Date [] theDate, int [] theSocial)
{
    if (theName == null || theDate == null || theSocial == null)
    {
         System.out.println("Fatal Error creating employee.");
         System.exit(0);
    }
    name = theName;
    birthdate = theDate;
    social = theSocial;
}