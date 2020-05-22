while (true) {
        System.out.print('\f');
        System.out.println("  " + board.getPosition(1) + "  |  " + board.getPosition(2) + "  | " + board.getPosition(3) + "   ");
        System.out.println("----------------");
        System.out.println("  " + board.getPosition(4) + "  |  " + board.getPosition(5) + "  | " + board.getPosition(6) + "   ");
        System.out.println("----------------");
        System.out.println("  " + board.getPosition(7) + "  |  " + board.getPosition(8) + "  | " + board.getPosition(9) + "   ");
        System.out.println();
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