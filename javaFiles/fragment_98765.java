int[] dx = {-1,1,0,0};
int[] dy = {0,0,-1,1};

for (int direction = 0; direction < 4; direction++) {
    int r = originalrow + dx[direction];
    int c = originalcol + dy[direction];

    while (buttons[r][c] != null && buttons[r][c].getIcon() != null) {
        Integer coordinate[] = getButtonCoord(buttons[r][c]);
        validCoordinates.add(coordinate);
        r += dx[direction];
        c += dy[direction];
        if (buttons[r][c].getIcon() != null) {// add valid coordinate
                                                // also to eat enemy
            if (buttons[r][c].getIcon().toString().charAt(0) == enemyColor) {
                validCoordinates.add(coordinate);
            }
        }
    }
}