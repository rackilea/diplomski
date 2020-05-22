Map map = new TreeMap();

Iterator itr = world.map.values().iterator();

while(itr.hasNext()){
    Tile t = (Tile)itr.next();
    System.out.print(t.xCord+","+t.yCord+","+t.zCord);
}