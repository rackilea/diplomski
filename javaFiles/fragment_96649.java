public static void main(String[] args) {
    int NumToGuess = 1+(int)(20*Math.random());
    int myGuess    = Integer.parseInt("10"); 
    System.out.println("Value is: " + NumToGuess);
    System.out.println("My Guess: " + myGuess);

    if (myGuess > NumToGuess) {
        System.out.println("Too Big");
    }
    else if (myGuess < NumToGuess) {
        System.out.println("Too Small");
    }

}