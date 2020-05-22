import java.util.*;

class Random_integer
{
    public static void main(String[] args){
        int integer1, integer2;
        Scanner input = new Scanner(System.in); 
        System.out.print("Enter two integer : \n ");
        System.out.print("\n Integer 1 : ");
        integer1 = input.nextInt();
        System.out.print("\n Integer 2 :");
        integer2 = input.nextInt();

        Random_integer ri = new Random_integer();
        ri.randomize(integer1,integer2);
    }

    public void randomize (int x,int y) {
        Random randomNum = new Random();
        int rand = randomNum.nextInt((y-x)+1)+x;
        System.out.print("\n Random number : " +rand);
    }
}