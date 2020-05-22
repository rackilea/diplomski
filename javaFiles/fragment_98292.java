void setDistance() {
    int distance;
    while (true) {
        System.out.print("Set distance.");
        distance = user.nextInt();
        if (distance < ableJump) {
            break;
        }
        System.out.print("Too far!");
    }
    jump(); 
    // after that:
    player = 3 - player;
    System.out.printf("Player %d's turn", player);
}