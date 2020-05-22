java.util.Random random = new java.util.Random();

for (int x = 0; x < WIDTH; x++) {
    ArrayList<Integer> yaxis = new ArrayList<Integer>();
    map.add(yaxis);
    for (int y = 0; y < HEIGHT; y++) {
        yaxis.add(random.nextInt(4));
    }
}