public static void printTree()
    {
        int index = 0;
        for(; index < 5; index++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(j <= index)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(j + 1);
                }
            }
            System.out.println();
        }
        for(; index > 0; index--)
        {
            for(int j = 0; j < 5; j++)
            {
                if(j < index)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(j + 1);
                }
            }
            System.out.println();
        }
    }