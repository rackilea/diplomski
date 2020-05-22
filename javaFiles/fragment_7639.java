Abstract class RoadElement{
  //abstract for simulation purpose, maybe randomized
  //calculation of next direction, etc.
}

class Road extends RoadElement{
  private RoadElement previous = null;
  private RoadElement next = null;
}

class Intersection extends RoadElement{
    private RoadElement northernConnection = null;
    private RoadElement easternConnection = null;
    private RoadElement southernConnection = null;
    private RoadElement westernConnection = null;
}