int rowLength = 9;
for (int points = 0; points <= rowLength; points++) {
    bool isOdd = points%2 == 1;
    if (isOdd)
    {
        int spaceOnSide = (rowLength-points)/2;
        for (int i=0; i<points;i++)
        {
            Console.Write(""+(i+spaceOnSide)+" ");
        }
    }
    else // even
    {
        int spaceOnSide = (rowLength-1-points)/2;
        for (int i=0; i<points/2;i++)
        {
            Console.Write(""+(i+spaceOnSide)+" ");
        }

        for (int i=points/2; i<points;i++)
        {
            Console.Write(""+(i+spaceOnSide+1)+" ");
        }           
    }
    Console.WriteLine();
}