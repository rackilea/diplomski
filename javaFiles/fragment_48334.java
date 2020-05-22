public void addSheep(int x, int y) {
    allSheep.put(new Point(x,y), new Sheep());
}

public void removeSheep(int x, int y) {
    allSheep.remove(new Point(x, y));
}