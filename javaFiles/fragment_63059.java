public static  boolean playerTurn = true;
        public static  boolean playerWon = false;
        public static  boolean computerWon = false;
        public static  boolean playing = true;
        public static  Scanner scan = new Scanner(System.in);
        public static  boolean playAgain = false;
        public static  int     player1WinCount = 0; //At game start nobody has won
        public static  int     player2WinCount = 0;


        public static  tictactoe board = new tictactoe();

        public static void main(String[] args){
                if(board.isVisible() == false){
                    board.setVisible(true);

    // Here I added the information about the counter    

        if (playerWon == true) {
            player1WinCount++;
            System.out.println("The player has won " + player1WinCount + " time(s)");
        }

        if (computerWon == true) {
            player2WinCount++;
            System.out.println("The computer has won " + player2WinCount + " time(s)");
        }

        if(playerWon == true || computerWon == true){

        System.out.println("Would you like to play again!? true or false");
        playAgain = scan.nextBoolean();
        if(playAgain == true ){
        board.setVisible(false);
        System.out.println("Player1 Won: " + playerWon);
        System.out.println("Player2 Won: " + computerWon);
        board.button1.setText("");
        board.button2.setText("");
        board.button3.setText("");
        board.button4.setText("");
        board.button5.setText("");
        board.button6.setText("");
        board.button7.setText("");
        board.button8.setText("");
        board.button9.setText("");                                              
        playerTurn = true;
        playerWon = false;
        computerWon = false;
        board.setVisible(true);
        else 

        System.out.println("Thanks for playing...! ");}