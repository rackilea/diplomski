public class MazeGame {

    public Maze createMaze() {
        // build the maze here.

        return aMaze;
    }

    public Room makeRoom(final int number) {
        return new Room(number);
    }

    public Wall makeWall() {
        return new Wall();
    }

    // ...
}


public class BombedMazeGame extends MazeGame {

    @Override
    public Room makeRoom(int number) {
        return new RoomWithABomb(number);
    }

    @Override
    public Wall makeWall() {
        return new BombedWall();
    }

}