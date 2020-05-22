room1.addExit( Direction.NORTH, room2 );
room1.addExit( Direction.WEST, room3 );

room2.addExit( Direction.SOUTH, room1 );

room3.addExit( Direction.EAST, room1 );