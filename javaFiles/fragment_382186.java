public static int specPyth(int num)
    {
        double a;
        for (int b = 1; b < num/2; b++)
        {
            a=(num*num/2 - num*b)/(num - b);

            if (a%1 == 0)
                return (int) (a*b*(num-a-b));
        }   

        return -1;
    }