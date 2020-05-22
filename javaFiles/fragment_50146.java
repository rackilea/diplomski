public void run() 
{
    while (winner == false)
    {
        position += speed;
        System.out.println(name + " is at position " + position );

        if(position >= 100)
        {
            winner = true;
            System.out.println(name + " is the winner of the race!");
            break;
        }

        try 
        {
            Thread.sleep((long) (0 + (Math.random()  * restMax)));
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

}