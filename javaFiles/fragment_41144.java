Elevator elevator1 = new Elevator();
elevator1.setStartingFloor(RandomFloor());

int numberOfElevatorCalls = 50;
for(int i = 0; i < numberOfElevatorCalls, i++){
    elevator1.addFloor(RandomFloor());
}

// sort
elevator1.sortFloors();

// print
elevator1.printFloors();