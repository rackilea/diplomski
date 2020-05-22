public void move(String direction)
{
    Room nextRoom = currentRoom.getNeighbor(direction);
    if (nextRoom == null){
        currentMessage = "You can't go in that direction";
    }
    else{
        currentRoom = nextRoom;
        currentMessage = currentRoom.getLongDescription();
    }
}