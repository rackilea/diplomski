zooA = new Zoo("ZooA");
zooA.addChild(new ZooQuadrant(Direction.SOUTH));
... so on for every quadrant ...
... same for zooB ...
home = new Place("Home");
world = new Place("World");
world.addChild(home);
world.addChild(zooA);
world.addChild(zooB);