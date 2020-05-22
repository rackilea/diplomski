public int [] diceArray;
private int gameValue;

public void rollDice()
{
    for(int i =0; i < diceArray.length; i++)
    {
        diceArray[i] = 6 *((int)Math.random()+ 1);
    }

}

public void printValues()
{
    for(int i=0; i < diceArray.length; i++)
    {
        System.out.println("Dice" + (i+1) +"is:" + diceArray[i]);
    }
}

public int calculatePetalsOnRose()
{
    gameValue = 0;
    for(int i = 0; i < diceArray.length; i++)
    {
        if(diceArray[i] == 5)
        {
            gameValue += 4;
        }
        else if (diceArray[i] == 3)
        {
            gameValue +=2;
        }
    }

    return gameValue;
}