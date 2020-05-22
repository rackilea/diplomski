public boolean checkIsSolved()
{
    //check if the game is complete after each valid move
    if (isSolved() == true) { 
        Intent i = new Intent(this, Congratulations.class); 
        startActivity(i);} 
        else
        {
            return false;
        }
    return false;
}