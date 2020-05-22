public class Hangar {
  String name; // e.g. A
  Set<Position> positions;
}

public class Position {
  String name; //e.g. A1
  Hangar hangar;
  Dimension dimension;
}