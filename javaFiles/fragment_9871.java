System.out.println(compareArrays(numbers));

public static boolean compareArrays(int[] numbers)
    {
        boolean b = true;
        int[] newNumbers = newNumbers();

        for(int x = 0; x < newNumbers.length; x++) 
        {
            if(newNumbers[x] == numbers[x])
            {
                b = true;
            }
            else
            {
                b = false;
            }
        }

        return b;
    }