import java.util.*;
 public class PatternOneTwoOne
   {
    public static void main(String[] args)
   {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter number of lines[height of triangle] : \t");
    int n = scan.nextInt();
    int k=0;
    for(int i=0; i<n; i++)
    {
        k=1;
        for(int j=0; j<(n+i); j++)
        {
           if(j<n-i-1)
                System.out.print(" ");
            else
            {
                System.out.print(""+k);
                if(j<(n-1))
                    k++;

                else
                    k--;
            }
        }
        System.out.println(" ");
    }
}

}