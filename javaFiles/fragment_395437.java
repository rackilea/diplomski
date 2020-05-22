Mover[] moveArray = {new RightMover(), new DownMover() new LeftMover(), new UpMover() };
for (i = 0; i < 4; i++) {
    while (myWumpus.moveArray[i]) {
        moveArray[i].move();
        generator.updateDisplay();
    }
}