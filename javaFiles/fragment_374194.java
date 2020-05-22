class Group {
    private List<Tile> tiles;

    public Group(List<Tile> tiles) {
        // defensive copy
        this.tiles = new LinkedList<>(tiles);
    }

    public Group() {
        this.tiles = new LinkedList<>();
    }

    public boolean add(Tile tile) {
        // validate *before* inserting
        return validate(tile) && tiles.add(tile);
    }
}