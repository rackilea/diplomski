public Floor getFloor(String floorName){
    Floor correctFloor = null;
    for(Floor floor : floors) {
        if(floor.Name == floorName) {
            correctFloor = floor;
        }
    }
    return correctFloor;
}