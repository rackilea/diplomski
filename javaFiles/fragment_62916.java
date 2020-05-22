if (P1 == P2) {
    System.out.println("It's a tie!");
}
else if (P1 == 1) {
    if (P2 == 2) {
        System.out.println("Player 2 wins!");
    }
    else {
        System.out.println("Player 1 wins!");
    }
}
else if (P1 == 2) {
    if (P2 == 1) {
        System.out.println("Player 1 wins!");
    }
    else {
        System.out.println("Player 2 wins!");
    }
}
else { // P1 == 3
    if (P2 == 1) {
        System.out.println("Player 2 wins!");
    }
    else {
        System.out.println("Player 1 wins");
    }
}