import java.util.*;
public class binarysearch{

     public static void main(String []args){
        double[] fileArray = {5, 100, 146.15, 314.56, 600.92};
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to search for an investment amount? (Y/N)");

        String answer= in.nextLine();//Prompt the user for binary search

        while (answer.equalsIgnoreCase("Y")) {
            System.out.println("Enter the investment amount");
            double userSrc = in.nextDouble();

            int n = fileArray.length;
            int first = 0;
            int last = n - 1;
            int middle = (first+last)/2;
            while (first <= last) {
                if (fileArray[middle] < userSrc)
                    first = middle + 1;    
                else if (fileArray[middle] == userSrc) {
                    System.out.printf("%f found at location %d.\n", userSrc, middle+1);
                    //return;
                    break;
                }
                else
                    last = middle - 1;

                    middle = (first + last)/2;
            }
            if (first > last)
                System.out.printf("Not found! %f isn't present in the list.\n", userSrc);

            //return;
            System.out.println("Would you like to search for an investment amount? (Y/N)");
            answer= in.nextLine(); 
        }
    }
}