public static void main (String[] args) throws java.lang.Exception
    {
        int x = -1;
        long seed = 0;
        int xxx = 100;
        while(x!=0){

            Random s = new Random(seed++);
            x = s.nextInt(xxx);

        }
        System.out.println("seed " + (seed-1) + " gives " + new Random(seed-1).nextInt(xxx));

    }