double angle = 90; // An example angle of 90 degrees
double length = 5; // An example length of 5

Location v1 = player.getLocation(); // The first vertex of the triangle, the player's location

double yaw = v1.getYaw(); // The player's yaw (in degrees) between 0º and 360º

World world = player.getWorld(); // The player's world

Location v2 = new Location(world, (-Math.sin(Math.toRadians(yaw - (angle / 2))) * distance) + v1.getX(), 0, (Math.cos(Math.toRadians(yaw - (angle / 2))) * distance) + v1.getZ()); // The second vertex
Location v3 = new Location(world, (-Math.sin(Math.toRadians(yaw + (angle / 2))) * distance) + v1.getX(), 0, (Math.cos(Math.toRadians(yaw + (angle / 2))) * distance) + v1.getZ()); // The third vertex