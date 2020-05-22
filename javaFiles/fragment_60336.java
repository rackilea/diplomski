glNewList(vertID, GL_COMPILE);
for (int x = sx; x < lx; x++) {
    for (int y = sy; y < ly; y++) {
        for (int z = sz; z < lz; z++) {
            tiles[x][y][z] = new Tile("grass.jpg");
        }
    }
}
glEndList();