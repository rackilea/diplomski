/**
 * @param args the command line arguments
 */
public static void main(String[] args)
{
    // Variables

    int start;
    int total = 0;


    //Methods

    Scanner quest = new Scanner (System.in);
    die1 x = new die1 ();
    die2 z = new die2 ();


    // Game

    System.out.println("Hello. Would you like to play PIG? 1 for yes");
    start = quest.nextInt();
    if (start == 1){
        x.roll();
        z.roll();
        total += 2; //You just rolled twice, so lets increment by 2

        System.out.println("You roll: "+ z.getEyes() + " " + x.getEyes());
        do {
            System.out.println("Would you like to roll again");
            start = quest.nextInt();
            if (start == 1)
            x.roll();
            z.roll();
            total += 2; //EDIT: Rolled again, so ingrement by 2 again
            System.out.println("You roll: "+ z.getEyes() + " " + x.getEyes());
        } while(z.getEyes() != 1 && x.getEyes() != 1);

        System.out.println("Total amount of rolls: " + total);

    }
}