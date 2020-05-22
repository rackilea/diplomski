public class CODE {

public static void main(String[] args) {
    Random rand = new Random();
    int n = rand.nextInt(100) + 1;
    Scanner input = new Scanner(System.in);

    System.out.println(n);
    System.out.println("Lets play a guessing game! You try to guess the number I am thinking \n");
    System.out.println("Guess a number between 1 to 100! ");

    String inputLine = input.nextLine();
    int line = Integer.parseInt(inputLine);

    boolean gotIt;
    gotIt=false;
    while(gotIt==false) {
        if (n<line) {
            System.out.println("Go Lower");
            inputLine = input.nextLine();
            line = Integer.parseInt(inputLine);
        }
        if (n>line) {
            System.out.println("Go Higher");
            inputLine = input.nextLine();
            line = Integer.parseInt(inputLine);
        }
        if (line==n) {
            System.out.println("You guessed my number!!!");
            gotIt=true;
            break;
        }
    }

}