//pick a random number
int number = getRandomNumber;
//pick 3 random free tiles
Tile[3] tiles = get3FreeTiles(board);
//fill these tiles
for(Tile t : tiles) {
    t.setNumber(number);
}