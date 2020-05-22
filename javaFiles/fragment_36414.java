int[][] combs = combinationsOf(combinations, 5);

    for (int i = 0 ; i < combs.length ; i++)
    {
        for(int j = 0 ; j < combs[i].length ; j++)
        {
            System.out.print(combs[i][j] + ", ");
        }
        System.out.println("");
    }


public static int[][] combinationsOf(int[] colorShape, int numPositions)
{
    int[][] combs = new int[(int)(Math.pow(colorShape.length, numPositions))][numPositions];

    int[] holding = new int[numPositions];
    for(int i = 0 ; i < numPositions ; i++)
    {
        holding[i]=0;
    }

    for(int i = 0 ; i < combs.length ; i++)
    {
        for(int j = 0 ; j < numPositions ; j++)
        {
            combs[i][j] = colorShape[holding[j]];   
        }
        incrementHolding(holding, colorShape.length);
    }
    return combs;
}

public static boolean incrementHolding(int[] holding, int max)
{
    for(int i = holding.length-1 ; i >= 0 ; i--)
    {
        if(holding[i]+1 == max)
        {
            if(i==0)
                return false;
            holding[i]=0;
        }
        else
        {
            holding[i]++;
            return true;
        }
    }
    return true;
}