for (int x = 0; x < WIDTH; x++) {
    ArrayList<Integer> yaxis = new ArrayList<Integer>();
    for (int y = 0; y < HEIGHT; y++) {
        yaxis.add(CLEAR);
    }
    map.add(yaxis);
}

for (int x = 0; x < WIDTH; x++) {
    ArrayList<Integer> yaxis = new ArrayList<Integer>();
    for (int y = 0; y < HEIGHT; y++) {
        yaxis.add(STONE);
    }
    map.add(yaxis);
}