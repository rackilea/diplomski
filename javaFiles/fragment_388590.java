public class SimpleShips {

static Scanner userInput = new Scanner(System.in);
static int hitsNum;
static int triesNum;
static int cell1;
static int cell2;
static int cell3;

static void setUp() {

    hitsNum = 0;
    //Cells 1-7
    cell1 = (int) (Math.random() * 5);
    cell2 = cell1 + 1;
    cell3 = cell1 + 2;

}

static void checkNum() {

    int tempNum;

    System.out.print("Choose a number from 1 to 7: ");

    if(userInput.hasNextInt()) {

         tempNum = userInput.nextInt();

         if(tempNum < 8 && tempNum > 0) {
             triesNum++;

             if(tempNum == cell1) {
                 cell1 = 0;
                 hitsNum++;
                 System.out.println("Hit!");
             } else if(tempNum == cell2) {
                 cell2 = 0;
                 hitsNum++;
                 System.out.println("Hit!");
             } else if(tempNum == cell3) {
                 cell3 = 0;
                 hitsNum++;
                 System.out.println("Hit!");
             } else {
                 System.out.println("Miss!");
             }   
         } else {
             System.out.println("Enter a number from 1 to 7!");
         }

    } else {

        System.out.println("You need to enter a number!");
        userInput.next();
    }
}

public static void main(String[] args) {

    System.out.println("Welcome to the one ship sinking game / BATTLESHIPS!");

    setUp();

    while(hitsNum < 3) {

        checkNum();
    }

    System.out.println("You successfully sank the ship! You sank it in " + triesNum + " tries.");
    System.out.print("Do you want to play again? ");

}

}