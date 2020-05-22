do {
    System.out.println("Please input the row where you want the aircraft carrier (5 spaces) to begin: ");
    beginrow = sonic.nextInt();
    System.out.println("Please input the column where you want the aircraft carrier (5 spaces) to begin: ");
    begincolumn = sonic.nextInt();
    System.out.print("Please input what direction (up, down, left, right) \nyou want your battle ship to face, making sure it doesn't go off of the board.");
    direction = sonic.next();
} while (!test(direction, beginrow, begincolumn, 5))