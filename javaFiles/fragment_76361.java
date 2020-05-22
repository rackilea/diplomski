final List<Tile> newTiles = new ArrayList<>();

for (final Tile tile: tiles) {
    if (tile.spread)
        continue;
    tile.spread = true;
    newTiles.add(new Tile(tile.position.x - tilesize, tile.position.y));
}

tiles.addAll(newTiles);