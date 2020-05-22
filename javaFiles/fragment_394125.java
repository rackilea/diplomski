public static void markOfMultiples(int[]listOfNumbers, int number)
    {
          for(int i = 0; i<listOfNumbers.length; i++)
        {
            if (listOfNumbers[i]%number == 0)
                {
                      listOfNumbers[i] = 0;
                }
            System.out.println(listOfNumbers[i]);//added by me to track what's going on
        }