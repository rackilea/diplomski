public static void main(String[] args) {

    int guess = 0;
    int tries = 3;
    Scanner input = new Scanner(System.in);
    Random ran = new Random();
    int diceNumber = ran.nextInt(6)+1;
    System.out.println(diceNumber);

System.out.println("Insert a number between 1 and 6 : you have " + tries + " tries.");
guess = input.nextInt();


while((tries >1 && guess != diceNumber)) {
    if((guess >=7 || guess<=0) && (tries >1)){
        --tries;
        System.out.println("Number out of range, try again; you have " + tries + " more tries.");
        guess = input.nextInt();
    }
    else {
        tries--;
        System.out.println("Incorrect Number, you have " +tries+ " more tries.");
        guess = input.nextInt();
    }

}

if(tries ==0 || guess != diceNumber)  {
    System.out.println("You Lose!!");

} else if(guess == diceNumber){
    System.out.println("You Win!!");
}

}