import java.util.Scanner;

public class testest {
    public static void main(String[] args){
        int n;
        String teman[],namadepan[];
        Scanner sc = new Scanner(System.in);
        Scanner x = new Scanner(System.in);

        System.out.print("Put how many friends : ");
        n = sc.nextInt();

        teman = new String[n];
        namadepan = new String[n];

        for(int i=0;i<n;i++){
            System.out.print("Friend Of-"+(i+1)+" : ");
            teman[i] = x.nextLine();
        }

        System.out.print("\n");

        for(int i=0;i<n;i++){
            System.out.println("First Name : ");
            System.out.println(teman[i].split(" ")[0]);
            System.out.print("\n");
        }
    }
}