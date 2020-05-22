public enum CellType {
    EMPTY, WALL, POWERUP
}

Scanner s = new Scanner(new File("map.txt"));
CellType[][] map = new CellType[8][8];
while (s.hasNext()) {
    String value = s.next().toUpperCase();
    int x = s.nextInt();
    int y = s.nextInt();
    map[x][y] = CellType.valueOf(value);
}