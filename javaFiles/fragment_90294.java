void getPlayerInput(char player) {       
    int row = -1;
    int col = -1;

    System.out.println(playerID(player) + ", it is your turn.");

    while(row==-1) {
        System.out.println("Select a cell [a, b, c, ... i]");

        char answer;
        answer = scan.next().charAt(0);

        switch(answer) {
        case 'a':
            row = 0;
            col = 0;
            break;          
        // <snip>
        default:
            System.out.println("Invalid location, try again.");
        }
        if(row !- -1 && ttt[row][col] != ' ') {
            System.out.println("This square is taken. Try again.");
            row = -1;
        }
    }
    ttt[row][col] = player;
}