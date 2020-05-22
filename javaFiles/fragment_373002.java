import java.util.Scanner;
import java.util.Random;
public class Project2 {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
    int min = 1;
    int max = 10;
    int colmax = 2;
    double balance = 2500.0;
    double bet1 = 0;
    double bet2 = 0;
    double profit1 = (bet1 * 2) - bet1;
    double profit2 = (bet2 * 5) - bet2;

    String kBet = null;
    System.out.println("          -==-==-==-==-==-==-==-==-==-==-"          );
    System.out.println("-==-==-=={ Welcome to the Marist Casino! }==-==-==-");
    System.out.println("          -==-==-==-==-==-==-==-==-==-==-"          );

    System.out.println("(1) Red Fox Roullete");
    System.out.println("(2) Crash");
    System.out.println("(3) Blackjack");
    System.out.print("Enter the number for the game you'd like to play!: ");
        int game = input.nextInt();

if(game == 1) {
   do {
    System.out.println("---------------------------------------------");
    System.out.println("Welcome to Red Fox Roullete!");
    System.out.print("Please choose Black or Red....and a number from 1-10: ");
    String color = input.next();
    int number = input.nextInt();

    System.out.print("Your available balance is $"+balance+". How much would you like to bet on "+color+"?");
    bet1 = input.nextInt();
    balance -= bet1;
    System.out.print("Your available balance is $"+balance+". How much would you like to bet on "+number+"?");
    bet2 = input.nextInt();
    balance -= bet2;

    System.out.println("------------------------------BET INFO------------------------------------");
    System.out.println("You just bet $"+bet1+" on "+color+" and $"+bet2+" on number "+number);
    System.out.println("Spinning............");
    System.out.println("------------------------------RESULTS-------------------------------------");

    Random rouletteNum = new Random();
    int rNum = min + rouletteNum.nextInt(max);
    int rCol = min + rouletteNum.nextInt(colmax);

    if (rCol == 1) {
        System.out.println("The machine landed on Black "+rNum);
    }
    else if(rCol != 1) {
        System.out.println("The machine landed on Red "+rNum);
    }

    if(rNum == number) {
        System.out.println("Congrats, you guessed the right number! You've won $"+profit2);
            balance += (bet2 * 5);
    }
    else if(rNum != number) {
        System.out.println("Sorry!You didnt guess the right number! You've lost "+bet2);
    }

    if(rCol == 1 && color.equals("Black")) {
        System.out.println("Congrats, you guessed the right color! You've won $"+profit1);
            balance += bet1 * 2 - bet1;
    }
    else if(rCol == 2 && color.equals("Red")) {
        System.out.println("Congrats, you guessed the right color! You've won $"+profit1);
            balance += bet1 * 2 - bet1;
    }       
    if(rCol == 2 && color.equals("Black")) {
        System.out.println("Sorry, you didn't guess the right color. You've lost $"+bet1);
    }
    else if(rCol == 1 && color.equals("Red")) {
        System.out.println("Sorry, you didn't guess the right color. You've lost $"+bet1);
    }


    System.out.println("After the bet, you're updated balance is $"+balance);
    System.out.println("-----------------------------------------------------------------");
    System.out.print("Yes or No? Would you like to place another bet in Roulette?");
        kBet = input.next();
    }

   while(kBet.equals("Yes"));
     if(kBet.equals("No")) {
        System.out.println("(1) Red Fox Roullete");
        System.out.println("(2) Blackjack");
        System.out.println("(3) Crash");
        System.out.print("Enter the number for the game you'd like to play!: ");
            game = input.nextInt();
} 

    }
    //CRASH
else if (game == 2) {
    do {
         int bet = 0;
         double start = 1.00;
         double crashValue = 1.00;
         int stopGame = 1;
         double cashout = 0;
         System.out.println("-------------------CRASH GAME--------------------------");
         System.out.println("Welcome to Crash!");
         System.out.print("What number would you like to cashout at?(Ex. 1.15):");
            cashout = input.nextDouble();
         System.out.print("Your balance is $"+balance+". How much would you like to bet on this round?:");
            bet = input.nextInt();
         System.out.println("--------------------------------------------------------------------------");
         System.out.println("Round is beginning........."); 

         for(int i =0; i < stopGame; i++) {
    do {
         double crash = Math.random() * 100;
         if (crash < 95) {
             start += .01;
             System.out.printf("%.2f\n",start);
         }
         else if(crash > 95) {
                 i++;
                 crashValue = start;
                 System.out.println("----------------------------RESULTS--------------------------------");
                 System.out.print("CRASH! The game crashed at "); 
                 System.out.printf("%.2f",start);
                 System.out.println("x"); 
         }
    } 
    while(i == 0);
   }
    if(cashout < crashValue) {
        System.out.println("Congrats! You cashed out at "+cashout+" before the game crashed. You've won $"+bet*cashout);
        balance += bet * cashout;
    }
    else {
        System.out.println("Sorry! The game crashed before you could cash out. You've lost $"+bet);
        balance -= bet;
    }
    System.out.println("After your bet, you're updated balance is $"+balance);
    System.out.println("-------------------------------------------------------------------");
    System.out.print("Yes or No? Would you like to play another round of Crash?: ");
     kBet = input.next();
}  
   while(kBet.equals("Yes"));
   if(kBet.equals("No")) {
        System.out.println("(1) Red Fox Roullete");
        System.out.println("(2) Blackjack");
        System.out.println("(3) Crash");
        System.out.print("Enter the number for the game you'd like to play!: ");
            game = input.nextInt();
     }
   }
//BlackJack Game
else if(game == 3) {
    Scanner input1 = new Scanner(System.in);
    System.out.println("---------------------Black Jack--------------------------");
    System.out.println("Welcome to BlackJack!");
    System.out.println("Available balance is $"+balance);
    System.out.print("How much would you like to bet on this hand?: ");
    int bet = input.nextInt();
    balance -= bet;
    System.out.println("You just bet $"+bet+"......Dealing cards!");
    System.out.println("----------------------------------------------------------");
    String pCard1 = dealCard();
    String pCard2 = dealCard();
    int value1 = getCardValue(pCard1);
    int value2 = getCardValue(pCard2);

    System.out.println("Your hand is a "+pCard1+" and a "+pCard2);
    System.out.print("Would you like to Hit or Stand?: ");
    String HitOrStand = input.next();
    }
}

    public static String dealCard() {
    int rCard = (int)Math.random() * 14;
    switch(rCard) {
    case 1 : return "2";
    case 2 : return "3";
    case 3 : return "4";
    case 4 : return "5";
    case 5 : return "6";
    case 6 : return "7";
    case 7 : return "8";
    case 8 : return "9";
    case 9 : return "10";
    case 10 : return "Queen";
    case 11 : return "Jack";
    case 12 : return "King";
    case 13 : return "Ace";
    }
        return "Unknown";
    }

    public static int getCardValue(String x) {
        if(x.equals("2")) {
            return 2;
        }
        if(x.equals("3")) {
            return 3;
        }
        if(x.equals("4")) {
            return 4;
        }
        if(x.equals("5")) {
            return 5;
        }
        if(x.equals("6")) {
            return 6;
        }
        if(x.equals("7")) {
            return 7;
        }
        if(x.equals("8")) {
            return 8;
        }
        if(x.equals("9")) {
            return 9;
        }
        if(x.equals("10")) {
            return 10;
        }
        if(x.equals("Queen")) {
            return 10;
        }
        if(x.equals("Jack")) {
            return 10;
        }
        if(x.equals("King")) {
            return 10;
        }
        if(x.equals("Ace")) {
            return 11;
        }
        return -1;
    }
}