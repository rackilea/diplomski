Boolean anyMatches = False;
For (int i= 0; i < 3 ; i++) 
{
    anyMatches = false;
    For (int j= 0; j < 3 ; j++) 
    {
        If (tripsList.get(i).get(0) == tripsList.get(j).get(1))
        {
            anyMatches = true;
        }
    }
    If (anyMatches == False)  
    {
        SystemThen.out.println("Your Departure City is "+tripsList.Get(i).Get(0));
    }
}