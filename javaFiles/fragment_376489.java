private final static List<Coordinate> directions;

static {
    List<Coordinate> dirs = new ArrayList<>();
    dirs.add(new Coordinate(1,-1));
    dirs.add(new Coordinate(-1,1));
    dirs.add(new Coordinate(-1,0));
    dirs.add(new Coordinate(1,0));
    dirs.add(new Coordinate(0,-1));
    dirs.add(new Coordinate(0,1));
    directions = Collections.immutableList(dirs);
}

public static List<Coordinate> makeDirections() {  // or getDirections()
    return directions;
}