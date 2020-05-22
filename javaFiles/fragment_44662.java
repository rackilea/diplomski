@Override
public void doSomething(int pos1, int pos2) {
    String tmp = (board[pos1][pos2].toString());
    shooting_board[pos1][pos2].damaged = true;
    shooting_board[pos1][pos2] = new ShipSection("X");
    //System.out.println(tmp);

    int tmp2 = (int)(tmp).charAt(0);
    //System.out.print(tmp2);
    tmp2 = tmp2 - 65;
    //System.out.println(tmp2);

    Ship ship = ships.get(tmp2);

    ship.hit();

    if(ship.hasSunk == true){
        sunk++;
        System.out.println("Sunk!");
        if(shipCount == sunk){
            PlayBoard();
            System.out.println("You win!");
            printStats();
            System.exit(0);
        }
    }
    totalMissilesFired++;
    numberOfHits++;
    PlayBoard();
    System.out.println("Hit!");
}