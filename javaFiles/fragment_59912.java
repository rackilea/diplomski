int rowLength = 9;
for (int points = 0; points <= rowLength; points++) {
    int spaceOnSide = (rowLength-points)/2;
    for (int i=0; i<points/2;i++)
    {
        Console.Write(""+(i+spaceOnSide)+" ");
    }
    for (int i=points/2; i<points;i++)
    {
        Console.Write(""+(i+spaceOnSide+(points+1)%2)+" ");
    }                   
    Console.WriteLine();
}