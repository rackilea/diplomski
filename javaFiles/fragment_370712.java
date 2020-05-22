List<Tile> tiles = new ArrayList<Tile>();
Iterator<Tile> tileIterator= tiles.iterator();
while (tileIterator.hasNext()) {
     Tile tile = tileIterator.next();
     tile.setColor("green");
}