public void setPlayerX(int x) {
    x = 1;
    playerX = x;
}
    public void moveDown(int height, int width, int x, int y) {
    x++;
    playerX = playerX + x;
    displayWorld(height, width, x, y);

}