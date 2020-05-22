private void moveRequest(int destinationX, int destinationY, Tile[][] map)
{
  //Just return if the tile is outside of the map
  if (!tileExists(destinationX, destinationY, map) return;
  //Same goes for your other checks...
  //Return if the tile is not walkable
  if (!tileIsWalkable(destinationX, destinationY, map) return;
  //Return if the tile is already occupied
  if (tileIsOccupied(destinationX, destinationY, otherEntities) return;
  //etc..  
  //Now the move is valid and you can set it's state to moving in that direction.
}