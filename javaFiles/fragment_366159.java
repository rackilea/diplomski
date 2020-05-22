public Map<Point, Tile> getDeepCopy(Map<Point, Tile> source) {
    Map<Point, Tile> copy = new HashMap<Point, Tile>();
    for (Map.Entry<Point, Tile> entry : source.entrySet())
        copy.put(entry.getKey(), entry.getValue().clone());
    return copy;
}