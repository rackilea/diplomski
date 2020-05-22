public class triangle
{
    public static void main(String args[])
    {
        int n = new Scanner(System.in).nextInt();
        while(n != 0)
            System.out.println(String.format("%0" + n-- + "d", 0).replace("0", "*"));
    }
}