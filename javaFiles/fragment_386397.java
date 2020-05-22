import java.util.Scanner;
class Bubblesorting
{
    Scanner sc=new Scanner(System.in);
    void ascendingOrder()
    {
        int[] no=new int[10];
        System.out.println("ENTER 10 NUMBERS");
        for(int i=0;i<no.length;i++)
        {
            no[i]=sc.nextInt();
        }
        int maxv = no[0];
        for (int i =0;i<10;++i) {
            if (no[i] > maxv) {
                maxv = no[i];
            }
        }
        System.out.println(maxv);
    }
}