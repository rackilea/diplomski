public static void convert( int input ) 
    {   
        if (input == 0) 
        {
           System.out.print(0);
           return;
        }
        convert(input / 2);
        System.out.print(input % 2);
    }