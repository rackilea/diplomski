static String partition (int n)
{
            int a=0;
            if (n<=1)
                return String.valueOf(n);
            while ((int)Math.pow(2, a)<=n)
                a++;

            return partition(n-((int)Math.pow(2, a-1)))+ 
            ....."+"+ String.valueOf(Math.pow(2, a-1));
}