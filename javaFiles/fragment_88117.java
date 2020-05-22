import java.io.*;
import java.util.*;

class Add {
    public static void main(String args[]) throws Exception {
        boolean loop=true;
        Scanner s=new Scanner(System.in);
        while(loop) {
            try {
                String yn;
                do {
                    loop = true;
                    System.out.println("Enter how many numbers to add: ");
                    int num=Integer.parseInt(s.next());
                    int a,sum=0;
                    for(int i=1;i<=num;) {
                        try {
                            System.out.println("Enter number["+i+"]: ");
                            a=Integer.parseInt(s.next());
                            sum=sum+a;
                            i++;
                        }
                        catch(Exception e) {
                            System.out.println("Invalid input. Try Again.\n");
                        }
                    }
                    System.out.println("The Sum is:"+sum);
                    System.out.println("Do you want to continue?(Y/N):");
                    yn=s.next();
                    loop = yn.equals("y")||yn.equals("Y");
                } while(loop);
            }
            catch(Exception e) {
                System.out.println("Number of elements invalid. Try Again.\n");
            }
        }
    }
}