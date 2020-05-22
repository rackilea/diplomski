public static void main(String [] args)
{
    int r = Integer.parseInt(args[0]);
    int g = Integer.parseInt(args[1]);
    int b = Integer.parseInt(args[2]);

    double c;
    double m;
    double y;
    double k;

    if ((r == 0 && g == 0)&&(g == 0 && b == 0))
    {
        c = 0;
        m = 0;
        y = 0;
        k = 0;
    }
    else         
    {
        int w = (int)(Math.max(r/255,(Math.max(g/255,b/255))));
        c = (double)((w-(r/255))/w);
        m = (double)((w-(g/255))/w);
        y = (double)((w-(b/255))/w);
        k = (double)(1-w);
    }
    System.out.println("cyan    =" + c);
    System.out.println("magenta =" + m);
    System.out.println("yellow  =" + y);
    System.out.println("black   =" + k);
}