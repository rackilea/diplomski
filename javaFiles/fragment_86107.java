public static void show (int [][] list)
{
    System.out.println ("- show: -");
    for (int [] ia : list) {
        for (int i : ia)
            System.out.print (i + ", ");
        System.out.println ();
    }
    System.out.println ("---");
}

static Random random = new Random ();

public static void main (String [] args)
{
    int[][] RAM = new int[4][2];
    for (int i = 0; i < 4; ++i)
    {
        for (int j = 0; j < 2; ++j)
        {
            RAM[i][j] = random.nextInt (20);
            System.out.print (i*2 +j);
        }
    }
    show (RAM);
    for (int i=0; i<4; i++) {
        Arrays.sort (RAM[i]);
    }
    show (RAM);
    System.out.println ();
}