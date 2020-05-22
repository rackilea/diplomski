public void setBirthDate(Date [] newDate)
{
    if (newDate == null)
    {
         System.out.println("Fatal Error setting person birthdate.");
         System.exit(0);
    }
    else
        birthDate = newDate;
}