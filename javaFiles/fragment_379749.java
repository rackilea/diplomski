public static boolean playGame() {

        Scanner in = new Scanner(System.in);
        System.out.print("What is your name: ");
        String myName = in.nextLine();

        Fighter a = new Warrior();
        Fighter b = new Dragon();
        a.pickOpponent(b);

        a.setName(myName);
        b.setName("Onyxia");

        System.out.print(getWelcome());     
        while(in.hasNextLine()) 
        {
            switch(in.nextLine()) 
            {
                case "no":
                    System.out.println("Wow, you are not even gonna try, you have lost!");
                    break;
                case "yes":
                    System.out.println("Let the fight begin! ");
                    while(a.isAlive() && b.isAlive()) 
                    {
                        System.out.println("Do you want to punch, kick, or headbutt the other fighter? ");
                        switch(in.nextLine()) 
                        {
                            case "punch":
                                System.out.println(a.getPunch(b));
                                System.out.println(b.getOpponentAttack(a));
                                break;
                            case "kick":
                                System.out.println(a.getKick(b));
                                System.out.println(b.getOpponentAttack(a));
                                break;
                            case "headbutt":
                                System.out.println(a.getHeadbutt(b));
                                System.out.println(b.getOpponentAttack(a));
                                break;
                            default :
                                System.out.println(invalidInput());
                                break;
                        }
                    }
                default:
                    System.out.println(a.getWinner(b));
                    break;  
            }//end of first switch statement
        }//end of first while loop
    }//end of playGame  

public static void main(String[] args) {

    while(playGame()) {}

}