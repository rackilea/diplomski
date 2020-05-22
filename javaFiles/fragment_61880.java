public class RobotZoneClass implements RobotZone {
    String[] map;

    public RobotZoneClass(int rows){
        map = new String[rows];
    }


    public void readMap(String newRow, int row) {
        // replaces row in map
        map[row]=newRow;
    }

    // rest of implementation
}