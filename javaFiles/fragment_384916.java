public class GameObjectDatabase implements LocationChangeListener {

    private int [] [] [] data;

    private Set<GameObjects> objects;

    ...

    public GameObject gameObjectAt(int x, int y, int z) {
        return data[x][y][z];
    }

    @Override
    public void positionUpdated(GameObject obj, int oldX, int oldY, int oldZ) {
      ....
    }

}