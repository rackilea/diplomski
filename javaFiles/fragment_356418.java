static void backTrack(int value)
    {
        //Check if the number has all 9 digits, that it is dividable
        if(isNine(value)) // CHANGED this if test. 
        {
            System.out.println("Found solution.");
            System.out.println(value);
            aantal++;
        }
        else
        {

            if(howMany(value) >= 9)
                return;

            for(int i = 1; i < 10; i++)
            {
                value = value * 10 + i;
                if(value % i == 0  && howMany(value) <= 9)
                {
                    //System.out.println(value);
                    backTrack(value);
                }
                value = value / 10;
            }
        }
    }

    //Gives length of integer for example 124 must give 3, 13 gives 2
    static int howMany(int value)
    {
        int test = value % 10;
        value = value / 10;
        int teller = 0;

        while(test != 0)
        {
            teller++;
            test = value % 10;
            value = value / 10;
        }
        return teller;
    }


    //Checks if the number has all digits from 1 to 9
    static boolean isNine(int value)
    {
        boolean values[] = new boolean[10];
        int test = value % 10;
        int counter = 0;

        for(int i = 1; i < values.length; i++)
            values[i] = false;

        while( test != 0)
        {
            if(values[test])
                return false;
            else
            {
                values[test] = true;
                value = value /10;
                test = value % 10;
            }
        }

        for(int i = 1; i < values.length; i++)
        {
            if(values[i])
                counter++;
        }

        if(counter == 9)
            return true;
        else
            return false;
    }
}