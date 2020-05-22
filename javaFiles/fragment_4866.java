private final int TILE_SIZE = 30;
private int[][] blocks;

private void loadMap(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            mapWidth = Integer.parseInt(reader.readLine());
            mapHeight = Integer.parseInt(reader.readLine());
            blocks = new int[mapHeight][mapWidth];

            for(int col = 0; col < mapHeight; col ++) {
                String line = reader.readLine();
                String[] tokens = line.split(" ");
                for(int row = 0; row < numBlocksRow; row++) {
                    blocks[col][row] = Integer.parseInt(tokens[row]);
                }
            }
            reader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

private void render(Graphics2D g) {
    for(int col = 0; col < mapHeight; col ++) {
        for(int row = 0; row < numBlocksRow; row++) {
            int block = blocks[col][row];
            Color color;
            if(block == 1) {
                color = Color.white;
            } else {
                color = Color.black;
            }
            g.fillRect(row * TILE_SIZE, col * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }
}