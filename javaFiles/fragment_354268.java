int input = 4;

        for(int i = 1; i <= input; i++)
        {
            int times = i;
            int length = 2 * i - 1;
            String str = "";
            for(int j = 0; j < length; j++)
            {
                str += i;
            }
            for(int k = 0; k < times; k++)
            {
                System.out.println(str);
            }
        }