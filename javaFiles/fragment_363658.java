Map<Key, Tile> map = new TreeMap<Key, Tile>();

Iterator<Tile> itr = world.map.values().iterator();

while(itr.hasNext()){
    Tile t = itr.next();
    System.out.print(t.xCord+","+t.yCord+","+t.zCord);
}