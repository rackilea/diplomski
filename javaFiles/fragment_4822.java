public class StackOverflow {
    public static void main(String[] args) {
        int a;
        int b;

        for (a=1; a<=3; a++)
        {
            // Only print the first row
            if (a == 1) {
                for (b=1; b<=3; b++)
                {
                    System.out.print(a*b + " ");
                }
                // Ends the first row 
                System.out.println("");
            } else {
                // Prints the rest of the first column
                System.out.println(a);
            } 
        }
    }
}