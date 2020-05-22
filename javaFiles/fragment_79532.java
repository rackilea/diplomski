Scanner s = new Scanner(new File("map.txt"));
String[][] map = new String[8][8];
while (s.hasNext()) {
    String value = s.next();
    int x = s.nextInt();
    int y = s.nextInt();
    map[x][y] = value;
}