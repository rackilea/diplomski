public class Loop7 {

    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in); //this is what allows the user to input their data from the console screen
        System.out.println("Please enter how many grades you want to insert : "); //this just outputs a message onto the console screen
        int num1 = scan.nextInt(); //This is the total number of grades the user provides and is saved in the variable named num1
        int num; //just a variable with nothing in it (null)
        double sum =0; //this variable is to hold the total sum of all those grades
        for(int i= 0; i<num1; i++) //loops as many times as num1 (if num1 is 3 then it loops 3 times)
        {
            System.out.println("Please enter a grade: "); //output message
            num = scan.nextInt(); //every time the loop body executes it reads in a number and saves it in the variable num
            sum += num; //num is then added onto sum (sum starts at 0 but when you add 3 sum is now 3 then next time when you add 1 sum is now 4 and so on)
        }
        System.out.println("the average is: "+(sum)/num1); //to get the average of a bunch of numbers you must add all of them together (which is what the loop is doing) and then you divide it by the number of items (which is what is being done here)  

    }