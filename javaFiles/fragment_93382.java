class GameMapSystem extends EntityProcessingSystem {
    @Mapper private ComponentMapper<MapPosition> pm;
    @Mapper private ComponentMapper<SolidObject> som;

    private ListMultimap<MapPosition, Entity> entityByLocation;

    private int[][] map;
    private int width, height;
    private Array<TerrainType> terrainTypes;

    /**
     * Accepts an Array of TerrainType objects and an 2d integer array with
     * values corresponding to indices into the array for the correct type.
     * 
     * In my case, these values are gleaned by reading a level description
     * file, but any source should be fine.
     */
    public GameMapSystem(Array<TerrainType> terrainTypes, int[][] map) {
        super(Aspect.getForAll(MapPosition.class));
        this.terrainTypes = terrainTypes;
        this.map = map;
        this.width = map.length;
        this.height = map[0].length;
        this.entityByLocation = ArrayListMultimap.create();
    }

    public boolean isOccupied(int x, int y) {
        List<Entity> entities = entityByLocation(new MapPosition(x, y));
        for(Entity e : entities) {
            if(som.has(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void inserted(Entity e) {
        this.entityByLocation.put(pm.get(e), e);
    }

    @Override
    protected void removed(Entity e) {
        this.entityByLocation.remove(pm.get(e), e);
    }

    /* additional EntityProcessingSystem overrides omitted */
}