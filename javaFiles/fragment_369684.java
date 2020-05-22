public class Main {


    static String cmdIF;
    static int x = 0;
    static int y = 0;
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        System.out.print("Welcome to the world! Which way do you want to go?");
        String northD = "You walk into a forest.";
        if(x ==1) {
            System.out.print(northD);
        }
        cmdIF = input.nextLine();
        choosePath();
    }
    public static void choosePath() {
        actionClass.cmdCenter(cmdIF, x, y);
    }
}