while (true) {
        drawBoard(board); //Replace with draw board
        System.out.print("Choose A Slot: ");
        slot = input.nextInt();
        if (swap == 1 || swap == 3 || swap == 5 || swap == 7 || swap == 9 || swap == 11) {
           board.setPosition(slot, player1Letter);
           swap++;
        } else if (swap == 2 || swap == 4 || swap == 6 || swap == 8 || swap == 10 || swap == 12) {
          board.setPosition(slot, player2Letter);
          swap++;
        }
        if (winner.isWinner(board) == true) {
            drawBoard(board); // Add the draw board.
            if (swap == 1 || swap == 3 || swap == 5 || swap == 7 || swap == 9 || swap == 11) {  //swap%2 == 1
                System.out.println();
                System.out.print(player2 + " Wins!");
                break;
            }
            if (swap == 2 || swap == 4 || swap == 6 || swap == 8 || swap == 10 || swap == 12) {
                System.out.println();
                System.out.print(player1 + " Wins!");
                break;
            } else if (winner.isWinner(board) == false) {
                System.out.println();
                System.out.print("Tie Game");
                break;
            }
        }
    }