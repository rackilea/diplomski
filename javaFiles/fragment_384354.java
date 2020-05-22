public static String printDots(int numDots)
      {
        String dots = "";
        for(int i = 0; i < numDots; i++)
         {
        dots += ".";
    }

return dots;
}


public static void main(String[] args)
{

    String[][] matrix = new String[10][10];
    int numDots = 4;
    for (int i = 0; i < matrix.length; i++)
    {

        for(int j = 0; j < matrix[i].length; j++)
        {
                matrix[i][j] = printDots(numDots);
        }
        if(i%2 != 0)
            numDots--;
    }

    for(int i = 0; i < matrix.length; i++)
    {
        for(int j= 0; j < matrix[i].length; j++)
            System.out.println(matrix[i][j]);
    }
    }
}