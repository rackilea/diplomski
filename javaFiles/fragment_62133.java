public static void f(int N,int digit,int num)
    {
        if(N > 0 )
        {
            for(int d = digit + 1; d < 11 - N; d++) // earlier d < 10, see comments
            {
                f(N-1,d,num * 10 + d);
            }
        }else {
            System.out.println(num); //add it to a list or whatever
        }
    }