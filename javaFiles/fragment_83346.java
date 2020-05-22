for (int y = columns(); y >= 0; y++) {
    for (int x = 0; x <= rows(); x++) {
        if (located && theLocation(y,x)) {
            result += "|" + youWin + "S ";
        } else if (mysterySpot[y][x] == 'S') {
            result += "|   ";
        } else {
            result += "| " + mysterySpot[y][x] + " ";
        }
    }
}