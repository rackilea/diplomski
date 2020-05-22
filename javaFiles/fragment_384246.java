public class ExamPaper2011
{
    public static void main(String [] args){

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        //here you get user input, maybe ask user what calculation he wants to do ^2 Or ^3
        //...get n from user input.
        //if he wants square
        print squaredNumber(n);
        //if he wants cubed
        print cubedNumber(n);
    }

    public static int squaredNumber(int n){
        return n*n;

    }

    public static int cubedNumber(int n){
        return n*squaredNumber(n);
    }

}