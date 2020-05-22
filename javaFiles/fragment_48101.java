public class Spacing 
{
    public static void main(String[]args)
    {
    Scanner c=new Scanner(System.in);
    System.out.println("Enter spaces between stars: ");
    int l=c.nextInt();



        String a="*";
        String b=" ";

        for(int i=0;i<5;i++)
        {
        for(int j=0;j<3;j++)
        {
            System.out.print(a);

             for(int k=0;k<l;k++)
             {
            System.out.print(b);
             }
        }
            System.out.println();
        }
     }
}